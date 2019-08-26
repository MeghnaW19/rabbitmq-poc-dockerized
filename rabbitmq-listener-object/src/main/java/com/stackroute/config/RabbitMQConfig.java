package com.stackroute.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private static final String MY_QUEUE = "EmployeeQueue";

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
        return ExchangeBuilder.topicExchange("EmployeeExchange")
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
            .with("Employee")
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
