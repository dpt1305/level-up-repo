package aden.dev.site.rwlock.safe;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import aden.dev.site.rwlock.ReadWriteSafe;

public class WriteRunner implements Runnable{

    private final ReentrantReadWriteLock lock;

    public WriteRunner(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public synchronized void run() {
        lock.writeLock().lock();
        System.out.println("Start writing");
        for (int i = 0; i < 10; i++) {
            ReadWriteSafe.sharedResource++;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        lock.writeLock().unlock();
    }
}
