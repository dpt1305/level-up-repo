package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {
    public static void main(String[] args) {
        String folderPath = System.getProperty("java.class.path");
        System.out.println(System.getProperty("java.class.path"));

        // BT2
        List<Class<?>> classList = findAllClassesFromDir(folderPath);
        for (Class<?> clazz : classList) {
            System.out.println(clazz.getName());
        }

        // BT3
        String jarPath = "/root/code/level-up-repo/bt2/NewTestingProject-1.0-SNAPSHOT.jar";
        File farFile = new File(jarPath);
        List<Class<?>> clazzList = findAllClassFromFileJar(farFile);
        for (Class<?> class1 : clazzList) {
            System.out.println(class1.getName() + "aaaa123");
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

    public static List<Class<?>> findAllClassFromFileJar(File givenFile) {
        List<Class<?>> clazzList = new ArrayList<>();
      
        try (JarFile jarFile = new JarFile(givenFile)) {
            Enumeration<JarEntry> e = jarFile.entries();
            while (e.hasMoreElements()) {
                JarEntry jarEntry = e.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName()
                        .replace("/", ".")
                        .replace(".class", "");
                    Class<?> clazz = Class.forName(className);
                    clazzList.add(clazz);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clazzList;
    }
}
