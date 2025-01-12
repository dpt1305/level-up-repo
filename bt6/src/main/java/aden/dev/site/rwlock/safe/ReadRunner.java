package aden.dev.site.rwlock.safe;

import aden.dev.site.rwlock.ReadWriteSafe;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadRunner implements Runnable{
    private final ReentrantReadWriteLock lock;

    public ReadRunner(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.readLock().lock();
            System.out.println("safe " + ReadWriteSafe.sharedResource);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
