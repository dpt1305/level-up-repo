package aden.dev.site;

public class SynchronizedFuncNotGood {
    public static int x = 0;
    public static void main(String[] args) {
        System.out.println("start: " + x);

        Thread th1 = new Thread(new RunnerAdd());
        Thread th2 = new Thread(new RunnerSub());

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end: " + x);
    }
}


class RunnerAdd implements Runnable {
    public RunnerAdd() {
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000000; i++) {
            SynchronizedFuncNotGood.x++;
        }
    }
}

class RunnerSub implements Runnable {
    public RunnerSub() {
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000000; i++) {
            SynchronizedFuncNotGood.x--;
        }
    }
}