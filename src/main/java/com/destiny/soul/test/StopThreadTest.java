package com.destiny.soul.test;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuhaifeng
 * @since 2020-10-13
 */
public class StopThreadTest {
    static class Runner implements Runnable{
        private volatile boolean on = true;
        private int i;
        @Override
        public void run() {
            while (on) {
                i++;
            }
            System.out.println(i);
        }
        public void clear(){
            on = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        new Thread(one).start();
        TimeUnit.SECONDS.sleep(1);
//        Runner two = new Runner();
        new Thread(one).start();
        TimeUnit.SECONDS.sleep(1);
        one.clear();
    }
}



