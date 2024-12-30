package aden.dev.site.rwlock.safe;

import aden.dev.site.rwlock.ReadWriteUnsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadRunner implements Runnable{
    private ReentrantReadWriteLock lock;

    public ReadRunner(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public synchronized void run() {
        try {
            lock.readLock().lock();
            System.out.println("safe " + ReadWriteUnsafe.sharedResource);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
//        try {
//            if(lock.readLock().tryLock(1000, TimeUnit.MILLISECONDS)) {
//                System.out.println(ReadWriteUnsafe.sharedResource);
//                try {
//                    Thread.sleep(1000);
//                    lock.readLock().
//                    lock.readLock().unlock();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        lock.readLock().lock();


    }
}
