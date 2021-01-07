package com.destiny.soul.configration;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: zhuhaifeng
 * Date: 2020-05-25
 */

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue directQueue(){
        return new Queue("directQueue",true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange", true, true);
    }

    @Bean
    public Binding testBind(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("directRoutingKey");
    }
}
