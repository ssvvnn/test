package com.destiny.soul.test;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuhaifeng
 * @since 2020-10-14
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runner());
        thread.start();
        TimeUnit.MICROSECONDS.sleep(200);
        thread.interrupt();
        System.out.println(thread.isInterrupted());

    }

    static class Runner implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (i < 200000) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                i++;
            }
            System.out.println(i);
        }
    }
}
