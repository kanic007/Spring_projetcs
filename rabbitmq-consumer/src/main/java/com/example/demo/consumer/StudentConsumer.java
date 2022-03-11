package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import com.example.demo.config.DirectExchangeConfig;
import com.example.demo.model.Student;

@Component
public class StudentConsumer {

	@RabbitListener(queues = DirectExchangeConfig.ROUTING_KEY)
    public void consumeMessageFromQueue(Student student) {
        System.out.println("Message recieved from queue : " + student);
    }
}
