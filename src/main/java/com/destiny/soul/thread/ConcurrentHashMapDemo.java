package com.destiny.soul.thread;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuhaifeng
 * @since 2020-10-29
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(22);
        //        HashMap<String, String> map = new HashMap<>(2);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100000; i++) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            map.put(UUID.randomUUID().toString(), "");
//                        }
//                    }, String.valueOf(i)).start();
//                }
//            }
//        });
//        thread.start();
//        thread.join();
        System.out.println("end");
    }
}
