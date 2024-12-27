package aden.dev.site;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncMakesWaiting {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Runner runner = new Runner();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(runner));
        }


        for (Thread thread : threads) {
            thread.start();
        }

//        System.out.println(new Date().toString());;


    }
}
class Runner implements Runnable {

    @Override
    public void run() {
        synchronized (this) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(new Date().toString());;
//        System.out.println("after sleep");
    }
}
