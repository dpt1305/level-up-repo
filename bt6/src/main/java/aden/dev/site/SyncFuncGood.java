package aden.dev.site;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncFuncGood {
    public static int shareResource = 0;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(100);

        RunnerAdd1 runner = new RunnerAdd1();

        for (int i = 0; i < 10; i++) {
            pool.execute(runner);
        }
        pool.shutdown();

        if(pool.isShutdown()) {
            System.out.println("Final value: " + SyncFuncGood.shareResource);
        }
    }
}
class RunnerAdd1 implements Runnable {

    @Override
    public synchronized void run() {
        for (int index = 0; index < 10; index++) {
            SyncFuncGood.shareResource++ ;

//            try {
//                SyncFuncGood.shareResource++ ;
//
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
    
}