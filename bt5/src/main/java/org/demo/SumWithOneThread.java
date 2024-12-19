package org.demo;

import java.util.ArrayList;
import java.util.List;

public class SumWithOneThread {
    private static final Integer ARRAY_LENGTH = 10000000;
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        

        for (int i = 0; i <= ARRAY_LENGTH; i++) {
            array.add(i);
        }

        RunCalculater runner1 = new RunCalculater(array, 0, ARRAY_LENGTH);

        Thread th1 = new Thread(runner1);

        long startTime = System.currentTimeMillis();

        th1.start();

        try {
            // Wait for all threads to finish
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long total = runner1.getSumary();

        System.out.println("Total time: " + (endTime - startTime));
        System.out.println("Total: " + total);

    }
}
