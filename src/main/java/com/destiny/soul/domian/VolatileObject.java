package com.destiny.soul.domian;

import lombok.SneakyThrows;

/**
 * @author zhuhaifeng
 * @since 2020-09-26
 */
public class VolatileObject {
    private int a = 0;
    private int b = 0;
    private boolean flag = false;

    public void writer() {
        flag = true;
        a = 1;
        b = 2;
    }

    public void reader() {
        System.out.println(flag);
            System.out.println(a);
            System.out.println(b);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileObject volatileObject = new VolatileObject();
        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                volatileObject.writer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
              volatileObject.reader();
            }
        });
        thread2.start();
        thread1.start();
    }
}
