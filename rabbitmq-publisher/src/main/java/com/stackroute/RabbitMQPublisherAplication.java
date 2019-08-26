package com.stackroute;

import com.stackroute.domain.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
to make use of RabbitTemplate, we implement CommandLineRunner
*/
@SpringBootApplication
public class RabbitMQPublisherAplication implements CommandLineRunner {

    /*
        allows us to send any kind of messages to RabbitMQ,
        be it a simple String message or an Object with fields,
        sub-fields, properties and everything and maybe a large file, mp3 file, img file
    */
    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQPublisherAplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        message will be delivered to amqp default exchange
        */
        /*
        don't use the default exchange instead use your oqn specific queues and exchanges
        */
        //rabbitTemplate.convertAndSend("***From Publisher***");

        /*
        this message will be delivered to TestQueue through TestExchange with testRouting as routing key
        */
        //rabbitTemplate.convertAndSend("TestExchange", "testRouting", "****From Publisher****");


        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("First Message");
        simpleMessage.setDescription("Simple Description");
        /*
        this SimpleMessage Object will be delivered to TestQueue through TestExchange with testRouting as routing key
        */
//        rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);


         /*
        this SimpleMessage Object will be delivered to MyQueye through MyTopicExchange with topic as routing key
        */
        rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simpleMessage);

    }
}
