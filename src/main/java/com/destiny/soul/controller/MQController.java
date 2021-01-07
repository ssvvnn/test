package com.destiny.soul.controller;

import afu.org.checkerframework.checker.oigj.qual.O;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * User: zhuhaifeng
 * Date: 2020-05-25
 */

@RestController
public class MQController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/mq")
    public void test(){
        HashMap<String,Object> map  = new HashMap<>(16);
        map.put("tttt", new Date());
        rabbitTemplate.convertAndSend("directExchange", "directRoutingKey", map);
    }

    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        IntStream.range(0, 5).forEach(value -> {
            new Thread(() -> {
                long id = Thread.currentThread().getId();
                threadLocal.set(value + "  " + id);
                threadLocal.set("abc");
                System.out.println(threadLocal.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
        System.out.println("last"+threadLocal.get());
        new ThreadLocal<>().set("abcd");
    }
}
