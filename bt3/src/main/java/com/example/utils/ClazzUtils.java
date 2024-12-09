package com.example.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.example.Main;
import com.example.annotations.Inject;

public class ClazzUtils {
    public static List<Class<?>> findAllClasses(Class<?> application) {
        String packageName = application.getPackageName();
        List<Class<?>> clazzList = new ArrayList<>();
        try {
            clazzList = findClassesInPackage(packageName);
            return clazzList;
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return clazzList;
    }

    public static List<Class<?>> findClassesInPackage(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Main.class.getClassLoader(); // Use Main's ClassLoader
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> directories = new ArrayList<>();

        // Collect all directories (resources) for the given package
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            directories.add(new File(resource.getFile()));
        }

        List<Class<?>> classes = new ArrayList<>();
        for (File directory : directories) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return classes;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().replace(".class", "");
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }

    public static <T> void injectObjectToProperty(Class<?> clazz, Map<String, Object> contextObject)
            throws IllegalAccessException {
        Object object = contextObject.get(clazz.getName());
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Class<?> propertyClazz = field.getType();
                field.set(object, contextObject.get(propertyClazz.getName()));
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
