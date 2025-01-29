package com.micro.service.storeservice.config;

import com.micro.service.storeservice.queue.GoodbyeReceiver;
import com.micro.service.storeservice.queue.Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Queue goodbye() {
        return new Queue("goodbye");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public GoodbyeReceiver goodbyeReceiver() {
        return new GoodbyeReceiver();
    }
}
