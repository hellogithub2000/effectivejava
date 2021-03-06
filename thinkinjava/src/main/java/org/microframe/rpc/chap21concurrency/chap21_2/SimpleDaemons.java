package org.microframe.rpc.chap21concurrency.chap21_2;

import java.util.concurrent.TimeUnit;

/**
 * used to
 * Created by tianjin on 8/3/16.
 */
public class SimpleDaemons implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }

        System.out.println("all thread start");
        Thread.sleep(175);
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
