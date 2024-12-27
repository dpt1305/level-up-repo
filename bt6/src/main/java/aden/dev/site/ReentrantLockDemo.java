package aden.dev.site;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Runner2 runner = new Runner2();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(runner));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        if (
                ReentrantLockDemo.lock.tryLock()
        ) {
            try {
                System.out.println("Inside the lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Outside the lock");
    }
}
