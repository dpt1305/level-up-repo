package aden.dev.site.rwlock;

public class RunnerWriting implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Start writing");
            for (int i = 0; i < 10; i++) {
                ReadWriteUnsafe.sharedResource++;
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
