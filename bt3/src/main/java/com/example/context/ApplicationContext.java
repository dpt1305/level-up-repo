package com.example.context;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.annotations.*;
import com.example.utils.ClazzUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class ApplicationContext {
    public static final Map<String, Object> contextObject = new HashMap<>();
    public static List<Class<?>> clazzList = new ArrayList<>();
    public static Class<?> applicationClazz;

    public static void run(Class<?> applicationClazz) {
        try {
            // Save applicationClazz
            ApplicationContext.applicationClazz = applicationClazz;

            HttpServerContext.initHttpServer();
            clazzList = ClazzUtils.findAllClasses(applicationClazz);

            for (Class<?> clazz : clazzList) {
                if ((clazz.isAnnotationPresent(ABean.class) || clazz.isAnnotationPresent(AService.class))
                        && !clazz.isInterface()) {
                    Object newObject = clazz.getConstructor().newInstance();

                    ApplicationContext.contextObject.put(clazz.getName(), newObject);
                    for (Class<?> interfaceClass : clazz.getInterfaces()) {
                        ApplicationContext.contextObject.put(interfaceClass.getName(), newObject);
                    }
                }
                if (clazz.isAnnotationPresent(AController.class)){
                    HttpServerContext.collectRequestMapping(clazz);
                }
            }
            for (Class<?> clazz : ApplicationContext.clazzList) {
                ClazzUtils.injectObjectToProperty(clazz, ApplicationContext.contextObject);
            }
            HttpServerContext.startHttpServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
