package com.example.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.annotations.ABean;
import com.example.utils.ClazzUtils;

public class ApplicationContext {
    private static final Map<Class<?>, Object> contextObject = new HashMap<>();
    private static List<Class<?>> clazzList = new ArrayList<>();
    private static List<Object> objectList = new ArrayList<>();

    public static void run(Class<?> applicationClazz) {
        try {
            clazzList = ClazzUtils.findAllClasses(applicationClazz);
            System.out.println(clazzList.size());
            for (Class<?> clazz : clazzList) {
                if (clazz.isAnnotationPresent(ABean.class) && !clazz.isInterface()) {
                    Object newObject = clazz.getConstructor().newInstance();

                    ApplicationContext.contextObject.put(clazz, newObject);
                    for (Class<?> interfaceClass : clazz.getInterfaces()) {
                        ApplicationContext.contextObject.put(interfaceClass, newObject);
                    }
                }
            }
            for (Class<?> clazz : ApplicationContext.clazzList) {
                ClazzUtils.injectObjectToProperty(clazz, ApplicationContext.contextObject);
            }
            System.out.println("hasdf ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
