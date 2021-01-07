package com.destiny.soul.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zhuhaifeng
 * @since 2020-10-27
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
    }
}
