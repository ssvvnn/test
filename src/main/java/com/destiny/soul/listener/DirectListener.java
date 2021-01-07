package com.destiny.soul.listener;

import com.sun.org.slf4j.internal.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: zhuhaifeng
 * Date: 2020-05-25
 */

@Component
@RabbitListener(queues = "directQueue")
public class DirectListener {
    @RabbitHandler
    public void testDirect(Map map){
        System.out.println(map.get("tttt"));
    }
}
