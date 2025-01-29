package com.micro.service.userservice.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue goodbye;

    @Autowired
    private Queue hello;

    AtomicInteger count = new AtomicInteger(0);

    public String send(Integer dots) {
        StringBuilder builder = new StringBuilder("Hello");
        for (int i = 0; i < dots; i++) {
            builder.append('.');
        }
        builder.append(count.incrementAndGet());
        String message = builder.toString();
        template.convertAndSend(hello.getName(), message);
        template.convertAndSend(goodbye.getName(), "Goodbye");
        return " [x] Sent '" + message + "'";
    }
}
