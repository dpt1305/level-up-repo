package aden.dev.site.rwlock;

import aden.dev.site.rwlock.unsafe.RunnerReading;
import aden.dev.site.rwlock.unsafe.RunnerWriting;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteUnsafe {
    public static int sharedResource = 0;
    private List<Thread> threadReadingList = new ArrayList<>();
    private List<Thread> threadWritingList = new ArrayList<>();

    public void run() {
        init();

        int i = 0;
        while(i<999) {
            threadReadingList.get(i).start();
            i++;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Write data
       for (Thread thread : threadWritingList) {
           thread.start();
           try {
               Thread.sleep(8000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

    private void init() {
        RunnerReading runnerRead = new RunnerReading();
        RunnerWriting runnerWrite = new RunnerWriting();

        for (int i = 0; i < 5; i++) {
            threadWritingList.add(new Thread(runnerWrite));
        }
        for (int i = 0; i < 1000; i++) {
            threadReadingList.add(new Thread(runnerRead));
        }
    }
}

