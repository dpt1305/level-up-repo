package org.demo;

import java.util.List;

public class RunCalculater implements Runnable{
    private List<Integer> array;
    private int start;
    private int end;
    private long sumary = 0;


    public RunCalculater(List<Integer> array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            for (int i = start; i <= end; i++) {
                sumary = sumary + array.get(i);
                // System.out.println(array.get(i));
            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public long getSumary () {
        return this.sumary;
    }
}
