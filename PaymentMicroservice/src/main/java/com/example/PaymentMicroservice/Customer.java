package com.example.PaymentMicroservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="payment")
public class Customer {
	  
	 private Integer id;
     private Integer customerId;
     private String customerName;
     private Integer amount;
     private String  status;
     
     public Customer() {
    	 
     }

	public Customer(Integer id, Integer customerId, String customerName, Integer amount, String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.amount = amount;
		this.status = status;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
	
	
	
	
}
