package com.rewards.service;

import java.util.List;

import com.rewards.entity.Customer;

public interface RewardsService {

	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(Integer customerId); 


}
