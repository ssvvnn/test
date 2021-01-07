package com.destiny.soul.thread;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * @author zhuhaifeng
 * @since 2020-10-19
 */
public class ConnectionPoolDemo {
    final LinkedList<Connection> list = new LinkedList<>();

    public void init(Integer size) {
        IntStream.range(0, size)
                .forEach(i -> list.add(new Connection()));
    }

    public Connection fetchConnection(Integer timeout) throws InterruptedException {
        synchronized (list) {
            if (timeout <= 0) {
                while (list.isEmpty()) {
                    list.wait();
                }
            } else {
                long future = System.currentTimeMillis() + timeout;
                long remaining = timeout;
                //while判断，防止中断出现的异常
                while (list.isEmpty() && remaining > 0) {
                    list.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
            }
            return list.remove();
        }
    }

    //todo:待优化
    public void releaseConnection(Connection connection) {
        synchronized (list) {
            list.add(connection);
            list.notifyAll();
        }
    }

    static class Connection {

    }
}
