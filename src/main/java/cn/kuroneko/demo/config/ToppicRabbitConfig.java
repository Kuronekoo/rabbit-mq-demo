package cn.kuroneko.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppicRabbitConfig {

    final static String messageQueue = "topic.message";
    final static String messagesQueue = "topic.messages";
    final static String testQueue1 = "test.queue1";

    @Bean
    public Queue queueMessage(){
        return new Queue(messageQueue);
    }


    @Bean
    public Queue queueMessages(){
        return new Queue(messagesQueue);
    }

    @Bean
    public Queue testQueue1(){
        return new Queue(testQueue1);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindExchangeMessages(Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindTestQueue1(Queue testQueue1,TopicExchange exchange){
        return BindingBuilder.bind(testQueue1).to(exchange).with("#");
    }
}
