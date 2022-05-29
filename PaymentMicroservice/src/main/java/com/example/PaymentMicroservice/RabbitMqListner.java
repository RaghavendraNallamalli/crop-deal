package com.example.PaymentMicroservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class RabbitMqListner {
    @Autowired
	private PaymentRepository paymentrepository;
    
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeMessageFromQueue(Customer c) {
    	   System.out.println("Message recieved from queue : " + c);
    	   Customer customer = paymentrepository.save(c);
    }
}
