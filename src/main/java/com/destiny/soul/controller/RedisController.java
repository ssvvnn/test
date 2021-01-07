package com.destiny.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisInvalidSubscriptionException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuhaifeng
 * @since 2020-09-11
 */
@RestController
public class RedisController {
    @Autowired
    private static  RedisTemplate redisTemplate;
    @GetMapping("/redis")
    public static void test() {
        String abc = (String)redisTemplate.opsForValue().get("abc");
        System.out.println(abc);
    }

    public static void main(String[] args) {
        test();
    }
}
