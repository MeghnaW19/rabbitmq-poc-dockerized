package com.stackroute;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitMQListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQListenerApplication.class, args);
    }
}
