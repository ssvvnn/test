package com.destiny.soul.test;

import lombok.SneakyThrows;

/**
 * @author zhuhaifeng
 * @since 2020-10-14
 */
public class WaitNotify {
    static final Object object = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new WaitRunner(), "waitThread");
        waitThread.start();
        Thread notifyRunner = new Thread(new NotifyRunner(), "NotifyRunner");
        notifyRunner.start();
    }

    static class WaitRunner implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (object) {
                object.wait();
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    static class NotifyRunner implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

