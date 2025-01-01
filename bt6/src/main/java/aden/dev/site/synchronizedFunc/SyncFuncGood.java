package aden.dev.site.synchronizedFunc;

import java.util.ArrayList;
import java.util.List;

public class SyncFuncGood {
    public static int shareResource = 0;

    public static void main(String[] args) {
        RunnerAdd1 runner = new RunnerAdd1();
        List<Thread> listThread = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            Thread t = new Thread(runner);
            listThread.add(t);
        }

        for(Thread t : listThread) {
            t.start();
        }

        for(Thread t : listThread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Final value: " + SyncFuncGood.shareResource);
    }
}
class RunnerAdd1 implements Runnable {

    @Override
    public synchronized void run() {
        for (int index = 0; index < 10000; index++) {
            SyncFuncGood.shareResource++ ;
        }
    }
    
}