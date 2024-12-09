package com.example;

import com.example.annotations.AHttpServer;
import com.example.context.ApplicationContext;

@AHttpServer
public class Main {
    public static void main(String[] args) {
        ApplicationContext.run(Main.class);
    }
}