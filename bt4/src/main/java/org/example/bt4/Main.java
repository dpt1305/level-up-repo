package org.example.bt4;

import com.example.annotations.AHttpServer;
import com.example.context.ApplicationContext;

@AHttpServer(port = "9090")
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext.run(Main.class);
    }
}