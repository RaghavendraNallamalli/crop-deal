package com.example.PaymentMicroservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins ={"http://localhost:3002","http://localhost:3002/PaymentDetails"})
@RestController
@RequestMapping(value="/Payment")
public class PaymentController {
	@Autowired
	private PaymentRepository paymentrepository;
	
	@GetMapping("/all")
	public List<Customer> findAll(){
		return paymentrepository.findAll();
	}

}
