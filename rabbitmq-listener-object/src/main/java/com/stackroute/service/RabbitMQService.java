package com.stackroute.service;

import com.stackroute.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements RabbitListenerConfigurer {

    @RabbitListener(queues = "${employeeinuse.rabbitmq.queue}")
    public void recievedMessage(Employee employee) {

        System.out.println("Recieved Message From RabbitMQ:" +employee.toString());
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
