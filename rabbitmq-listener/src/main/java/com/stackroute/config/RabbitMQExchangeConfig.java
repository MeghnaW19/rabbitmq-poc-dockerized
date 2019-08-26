/*
package com.stackroute.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/*
way to create exchanges
*//*

@Configuration
public class RabbitMQExchangeConfig {

    */
/*
    bean for Topic Exchange
    *//*

    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("TopicExchange");
    }

    */
/*
    bean for Direct Exchange through ExchangeBuilder
    *//*

    @Bean
    Exchange exampleExchange2() {
        return ExchangeBuilder.directExchange("DirectExchange")
                .autoDelete()
                .internal()
                .build();
    }

    */
/*
    bean for Topic Exchange through ExchangeBuilder
    *//*

    @Bean
    Exchange exampleExchange3() {
        return ExchangeBuilder.topicExchange("TopicExchange2")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    */
/*
  bean for Fanout Exchange through ExchangeBuilder
  *//*

    @Bean
    Exchange exampleExchange4() {
        return ExchangeBuilder.fanoutExchange("FanoutExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    */
/*
    bean for Headers Exchange through ExchangeBuilder
    *//*

    @Bean
    Exchange exampleExchange5() {
        return ExchangeBuilder.headersExchange("TopicExchange2")
                .autoDelete()
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }


}
*/
