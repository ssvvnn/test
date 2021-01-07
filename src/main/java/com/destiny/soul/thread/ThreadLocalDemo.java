package com.destiny.soul.thread;

/**
 * @author zhuhaifeng
 * @since 2020-10-18
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 6);
//        threadLocal.set(threadLocal.get() + 1);
//        System.out.println(threadLocal.get());
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(1);
        threadLocal1.remove();
        System.out.println(threadLocal1.get());
    }
}
