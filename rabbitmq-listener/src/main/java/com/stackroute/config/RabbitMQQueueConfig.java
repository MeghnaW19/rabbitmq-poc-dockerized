/*
package com.stackroute.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/*
ways of creating queues
*//*

@Configuration
public class RabbitMQQueueConfig {
    */
/*
    name the queue to listen to
    *//*

    private static final String MY_QUEUE1 = "ExampleQueue";

    */
/*
    define the queue to listen to and create it
   *//*

    @Bean
    Queue exampleQueue1() {
        return new Queue(MY_QUEUE1, false);
    }

    @Bean
    Queue exampleQueue2() {
        return QueueBuilder.durable("ExampleQueue2")
                .autoDelete()
                .exclusive()
                .build();

    }



}
*/
