package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

import com.example.annotations.Inject;

public class ClazzUtils {
    public static List<Class<?>> findAllClasses(Class<?> application) {
        String packageName = application.getPackageName();

        InputStream stream = application.getClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> line.replaceAll(".class", ""))
                .map((className) -> {
                    try {
                        return Class.forName(packageName + "." + className);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

     public static <T> void injectObjectToProperty(Class<?> clazz, Map<Class<?>, Object> contextObject)
            throws IllegalAccessException {
        Object object = contextObject.get(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Class<?> propertyClazz = field.getType();
                field.set(object, contextObject.get(propertyClazz));
            }
        }
    }


    public static List<Class<?>> findAllClassesFromDir(String dir) {
        List<Class<?>> classFiles = new ArrayList<>();
        
        File mainFolder = new File(dir);
        Stack<File> stack = new Stack<>();
        stack.push(mainFolder);

        while(!stack.empty()) {
            File folder = stack.pop();
            if (folder.exists() && folder.isDirectory()) {
                for (File file : folder.listFiles()) {
                    if (file.isDirectory()) {
                        File subFolder = file;
                        stack.push(subFolder);
                    } else if (file.getName().endsWith(".class")) {
                        String modifiedClazz = file.getAbsolutePath()
                            .replaceFirst(dir+"/", "")
                            .replace("/", ".");
                        String modifiedClazzWithoutExtension =  modifiedClazz.substring(0, (modifiedClazz.length() - ".class".length()));
                        
                        try {
                            Class<?> loadedClass = Class.forName(modifiedClazzWithoutExtension);
                            classFiles.add(loadedClass);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
        return classFiles;
    }
}
