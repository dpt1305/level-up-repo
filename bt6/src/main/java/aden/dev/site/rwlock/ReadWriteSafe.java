package aden.dev.site.rwlock;

import aden.dev.site.rwlock.safe.ReadRunner;
import aden.dev.site.rwlock.safe.WriteRunner;
import aden.dev.site.rwlock.unsafe.RunnerReading;
import aden.dev.site.rwlock.unsafe.RunnerWriting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteSafe {
    public static int sharedResource = 0;
    private List<Thread> threadReadingList = new ArrayList<>();
    private List<Thread> threadWritingList = new ArrayList<>();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void run() {
        init();

        // Write data
//        for (Thread thread : threadWritingList) {
//            thread.start();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        int i = 0;
        while(i<999) {
            threadReadingList.get(i).start();
            i++;
            if( i == 1 || i == 4) {
                threadWritingList.get(i).start();
            }
        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


    }

    private void init() {
        ReadRunner runnerRead = new ReadRunner(this.readWriteLock);
        WriteRunner runnerWrite = new WriteRunner(this.readWriteLock);

        for (int i = 0; i < 5; i++) {
            threadWritingList.add(new Thread(runnerWrite));
        }
        for (int i = 0; i < 1000; i++) {
            threadReadingList.add(new Thread(runnerRead));
        }
    }
}
