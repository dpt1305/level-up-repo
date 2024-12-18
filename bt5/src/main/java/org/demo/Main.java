package org.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static final Integer MAX_NUMBER = 1000;
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<Integer, Integer> mainMap = new HashMap<>();
        initMap(mainMap);

        Thread readThread = new Thread(new Runner1(mainMap));
        Thread writeThread = new Thread(new Runner2(mainMap));

        // try {
        //     Thread.sleep(100);
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        readThread.start();
        writeThread.start();
    }

    public static void initMap(Map<Integer, Integer> mainMap) {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            mainMap.put(i, i);
        }
    }


}
class Runner1 implements Runnable {
    private Map<Integer, Integer> map;

    public Runner1( Map<Integer, Integer> map ) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 1; i <= Main.MAX_NUMBER; i++) {
            System.out.println(i + ": " + map.get(i));
        }
    }
    
}

class Runner2 implements Runnable {
    private Map<Integer, Integer> map;

    public Runner2( Map<Integer, Integer> map ) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(105);
            map.put(1000, -1);
            // for (int i = Main.MAX_NUMBER; i >0; i--) {
            //     map.put(i, -1);
            // }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}