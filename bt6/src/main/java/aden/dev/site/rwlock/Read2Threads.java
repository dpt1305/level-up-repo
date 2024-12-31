package aden.dev.site.rwlock;

import java.util.concurrent.locks.ReentrantLock;

public class Read2Threads {
    public void run() {
        ReentrantLock lock = new ReentrantLock();
        Thread th1 = new Thread(new RunnerRead2(lock, "thread1"));
        Thread th2 = new Thread(new RunnerRead2(lock, "thread2"));

        th1.start();
        th2.start();


    }
}

class RunnerRead2 implements Runnable {

    private ReentrantLock lock;
    private String threadName;

    public RunnerRead2(ReentrantLock lock, String threadName) {
        this.lock = lock;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if (lock.tryLock()) {
            try {
                System.out.println(this.threadName + " - Inside of waiting block");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }



        }
        System.out.println(this.threadName + " - Out of waiting block");
    }
}
