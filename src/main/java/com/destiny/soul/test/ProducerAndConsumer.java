package com.destiny.soul.test;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhuhaifeng
 * @since 2020-10-14
 */
public class ProducerAndConsumer {
    static final int capacity = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> container = new ArrayList<>();
        Thread producer = new Thread(new Producer(container), "producer");
        Thread consumer = new Thread(new Consumer(container), "consumer");
        producer.start();
        producer.join();
        consumer.start();
    }

    static class Producer implements Runnable {
        final List<Integer> container;

        public Producer(List<Integer> container) {
            this.container = container;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (container) {
                    while (container.size() == capacity) {
                        System.out.println("容量满了");
                        container.wait();
                    }
                    int number = new Random().nextInt();
                    container.add(number);
                    System.out.println("produce " + number);
                    container.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        final List<Integer> container;

        public Consumer(List<Integer> container) {
            this.container = container;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (container) {
                    while (container.isEmpty()) {
                        System.out.println("容器空了");
                        container.wait();
                    }
                    Integer remove = container.remove(0);
                    System.out.println("consume " + remove);
                    container.notify();
                }
            }
        }
    }
}
