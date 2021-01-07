package com.destiny.soul.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author z
 */
@Component
public class WebSocketController implements BeanNameAware, BeanFactoryAware, BeanPostProcessor {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String s) {

    }
//    @Autowired
//    RedisTemplate redisTemplate;
//    @PostConstruct
//    public void websocket(){
//        String abc =(String) redisTemplate.opsForValue().get("abc");
//        System.out.println(abc);
//        System.out.println("-----------------------------");
//    }
//
//    @Override
//    public void setBeanName(String s) {
//        s = "123";
//        System.out.println(s+"--------------------------------------------------------------");
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println(beanFactory.isSingleton("webSocketController"));
//    }
}
