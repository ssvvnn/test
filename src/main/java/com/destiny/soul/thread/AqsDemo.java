package com.destiny.soul.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhaifeng
 * @since 2020-10-18
 */
public class AqsDemo {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new OneTask(), "one").start();
        new Thread(new TwoTask(), "two").start();
    }

    static class OneTask implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class TwoTask implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("----------");
            } finally {
                lock.unlock();
            }
        }
    }
}
