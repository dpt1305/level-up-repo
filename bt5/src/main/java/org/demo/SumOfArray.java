package org.demo;

import java.util.ArrayList;
import java.util.List;

public class SumOfArray {
    private static final Integer ARRAY_LENGTH = 10000000;
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i <= ARRAY_LENGTH; i++) {
            array.add(i);
        }

        RunCalculater runner1 = new RunCalculater(array, 0, 3000000);
        RunCalculater runner2 = new RunCalculater(array, 3000001, 6000000);
        RunCalculater runner3 = new RunCalculater(array, 6000001, ARRAY_LENGTH);

        Thread th1 = new Thread(runner1);
        Thread th2 = new Thread(runner2);
        Thread th3 = new Thread(runner3);

        long startTime = System.currentTimeMillis();


        th1.start();
        th2.start();
        th3.start();

        try {
            // Wait for all threads to finish
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        long total = runner1.getSumary() + runner2.getSumary() + runner3.getSumary();

        System.out.println("Total time: " + (endTime-startTime));
        System.out.println("Total: " + total);

    }
    
}
