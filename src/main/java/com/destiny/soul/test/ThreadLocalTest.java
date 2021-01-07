package com.destiny.soul.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuhaifeng
 * @since 2020-10-12
 */
public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadLocalTest.add("一枝花算不算浪漫");
//        System.out.println(holder.get().messages);
//        ThreadLocalTest.clear();
//        TimeUnit.SECONDS.sleep(1000);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1234");
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println("end");
    }
}
