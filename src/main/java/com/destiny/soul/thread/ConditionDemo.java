package com.destiny.soul.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhaifeng
 * @since 2020-10-27
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try{
            condition.await();
        } finally {
            lock.unlock();
        }
    }
}
