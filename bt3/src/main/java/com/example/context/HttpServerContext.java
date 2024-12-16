package com.example.context;

import com.example.annotations.AController;
import com.example.annotations.AGetMapping;
import com.example.annotations.AHttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class HttpServerContext {
    private static HttpServer server ;
    private static String port = null;

    public static void initHttpServer() throws IOException {
        if (ApplicationContext.applicationClazz.isAnnotationPresent(AHttpServer.class)) {
            AHttpServer adenHttp = ApplicationContext.applicationClazz.getAnnotation(AHttpServer.class);
            port = adenHttp.port();

            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(port)), 0);
        }
    }
    public static void startHttpServer() {
        // Run http server
        server.start();
        System.out.println("Server run on: " + server.getAddress());
    }

    public static void collectRequestMapping(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object newObject = clazz.getDeclaredConstructor().newInstance();
        String controllerPath = clazz.getAnnotation(AController.class).path();

        for (Method method : clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(AGetMapping.class)) {
                String methodPath = method.getAnnotation(AGetMapping.class).path();
                String path = String.join("", controllerPath, methodPath);

                server.createContext(path, (HttpHandler) exchange -> {
                    method.setAccessible(true);
                    String response = null;
                    try {
                        response = (String) method.invoke(newObject, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                    exchange.sendResponseHeaders(200, response.getBytes().length);

                    // Write the response body
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                });

            }
        }

        ApplicationContext.contextObject.put(clazz.getName(), newObject);
        for (Class<?> interfaceClass : clazz.getInterfaces()) {
            ApplicationContext.contextObject.put(interfaceClass.getName(), newObject);
        }
    }
}
