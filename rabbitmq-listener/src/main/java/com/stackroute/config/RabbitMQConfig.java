package com.stackroute.config;


import com.stackroute.listener.RabbitMQMessageListener;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
class for handling connections to queue and actual RabbitMQ broker
*/
@Configuration
public class RabbitMQConfig {
    /*
        name the queue to listen to
    */
    private static final String MY_QUEUE = "MyQueue";

    /*
       define the queue to listen to and create it
   */
    @Bean
    Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }

    /*
    create an exchange
    */
    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange("MyTopicExchange")
                .durable(true)
                .build();
    }

    /*
    bind exchange and queue
    */
    @Bean
    Binding binding() {
//        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE, "MyTopicExchange", "topic", null);
    return BindingBuilder
            .bind(myQueue())
            .to(myExchange())
            .with("topic")
            .noargs();
    }


    /*
        bean for creating connction to RabbitMQ broker
    */
    @Bean
    ConnectionFactory connectionFactory() {
        /*
        for connection to be stable
        */
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }


    /*
    bind the Queue, Connection and Listener
    */
    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        /*
        set the actual message listener class
        */
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
        return simpleMessageListenerContainer;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
