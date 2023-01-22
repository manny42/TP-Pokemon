package com.micro.service.storeservice.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.Random;

@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("[x] Received '" + in + "'");

        Random rand = new Random();
        int int_random = rand.nextInt(4);
        if (int_random % 4 == 0) {
            throw new InterruptedException("This is an error!");
        }

        doWork(in);
        watch.stop();
        System.out.println("[x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}