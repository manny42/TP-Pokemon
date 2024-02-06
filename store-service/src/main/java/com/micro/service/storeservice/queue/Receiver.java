package com.micro.service.storeservice.queue;

import com.rabbitmq.client.GetResponse;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@RabbitListener(queues = "hello")
@Component
public class Receiver {
    @Autowired
    RabbitTemplate template;

    @Autowired
    MessageConverter messageConverter;

    String queueName = "hello";

    private volatile MessagePropertiesConverter messagePropertiesConverter = new DefaultMessagePropertiesConverter();

    // Pour éviter la surcharge avec les messages remis en queue en cas d'erreur, nous utilisons un cron pour récupérer les messages
    @Scheduled(fixedRate = 2000)
    private void receive() {
        Object bar = template.execute(channel -> {
            GetResponse response = channel.basicGet(queueName, false);
            if (response != null) {
                String result = null;
                try {
                    MessageProperties messageProps = messagePropertiesConverter.toMessageProperties(response.getProps(), response.getEnvelope(), "UTF-8");
                    if(response.getMessageCount() >= 0) {
                        messageProps.setMessageCount(response.getMessageCount());
                    }
                    Message message = new Message(response.getBody(), messageProps);
                    // Conversion du Byte Array du message vers une string
                    result = (String) messageConverter.fromMessage(message);
                    // Envoie du Ack au broker RabbitMq pour le supprimer de la queue
                    channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
                }
                catch(Exception e) {
                    // Envoie du Nack au broken RabbitMq afin qu'il soit remis dans la queue
                    channel.basicNack(response.getEnvelope().getDeliveryTag(), false, true);
                }
                return result;
            }
            return null;
        });
        System.out.println(bar);
    }
}
