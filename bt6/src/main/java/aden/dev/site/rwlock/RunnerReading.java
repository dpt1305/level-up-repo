package aden.dev.site.rwlock;

public class RunnerReading implements Runnable {

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
