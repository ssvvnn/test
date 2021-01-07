package com.destiny.soul.utils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhaifeng
 * @since 2020-09-21
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        synchronized (Singleton.class) {
            if (singleton == null) {  
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
