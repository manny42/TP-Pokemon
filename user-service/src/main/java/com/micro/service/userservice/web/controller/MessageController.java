package com.micro.service.userservice.web.controller;

import com.micro.service.userservice.queue.Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private Sender sender;


    @GetMapping
    public String sendMessage(@RequestParam Integer workload) {
        return this.sender.send(workload);
    }
}
