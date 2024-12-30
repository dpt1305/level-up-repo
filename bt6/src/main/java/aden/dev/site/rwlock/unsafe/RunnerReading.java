package aden.dev.site.rwlock.unsafe;

import aden.dev.site.rwlock.ReadWriteUnsafe;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RunnerReading implements Runnable {
    private ReentrantReadWriteLock lock;

    public RunnerReading() {}
    public RunnerReading(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(ReadWriteUnsafe.sharedResource);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
