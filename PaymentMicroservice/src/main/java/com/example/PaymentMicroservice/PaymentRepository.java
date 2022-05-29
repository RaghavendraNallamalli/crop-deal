package com.example.PaymentMicroservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
@Component
public interface PaymentRepository extends  MongoRepository<Customer,Integer>{
	

}
