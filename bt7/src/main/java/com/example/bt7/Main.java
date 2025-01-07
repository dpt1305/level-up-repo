package com.example.bt7;

public class Main {
    public static void main(String[] args) {
        DatabaseEngine dbEngine = new DatabaseEngine();
        Person a = dbEngine.findWithoutIndex("A");
        if(a != null) {
            System.out.println(a.getName());

        }

        dbEngine.initIndexing();
        Person b = dbEngine.findWithIndex("B");
        System.out.println(b.getName());

        // B-tree => 
    }
}