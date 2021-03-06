package org.microframe.rpc.chap21concurrency.chap21_2;


/**
 * used to
 * Created by tianjin on 8/3/16.
 */
public class LiftOff implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10;

    public LiftOff() {
        super();
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "). ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
