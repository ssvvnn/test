package com.destiny.soul.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhaifeng
 * @since 2020-10-18
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        InterruptRunner interruptRunner = new InterruptRunner();
        Thread thread = new Thread(interruptRunner);
        Thread thread1 = new Thread(interruptRunner);
        thread1.start();
        thread.start();
        thread.interrupt();
    }
    static class Runner implements Runnable {

        @Override
        public void run() {
            Lock lock = new ReentrantLock();
            lock.lock();
            try {
                while (true) {
                    System.out.println(123);
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            } finally {
                lock.unlock();
            }
        }
    }
    static class SynRunner implements Runnable {
        Object object = new Object();
        @Override
        public void run() {
           synchronized (object) {
               while (true) {
                   System.out.println(123);
                   System.out.println(Thread.currentThread().isInterrupted());
               }
           }
        }
    }
    static class InterruptRunner implements Runnable {

        @Override
        public void run() {
            Lock lock = new ReentrantLock();
            try {
                lock.lockInterruptibly();
                System.out.println(123);
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            }finally {
                lock.unlock();
            }
        }
    }
}
