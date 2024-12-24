package org.demo;

/**
 * Mọi người tìm hiểu tình huống giả sử có 1 số nguyên x bằng 0,
 * có 2 thread, 1 thread x++, 1 thread x--
 * thì sau khi 2 thread này thực hiện xong, những value nào của x có thể xảy ra?
 */
public class ThreadCalculateUnsafe {
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
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            ThreadCalculateUnsafe.x++;
        }
    }
}

class RunnerSub implements Runnable {
    public RunnerSub() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            ThreadCalculateUnsafe.x--;
        }
    }
}