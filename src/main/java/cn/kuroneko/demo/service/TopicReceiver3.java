package cn.kuroneko.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test.queue1")
public class TopicReceiver3 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver3 and i want everything : " + message);
    }

}