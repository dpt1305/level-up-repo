package aden.dev.site.reentrantlockVsSynchronizedFunc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncMakesWaiting {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Runner runner = new Runner();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(runner));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
class Runner implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("inside lock");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(new Date().toString());

        
    }
}
