package com.rewards.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.entity.Customer;
import com.rewards.repo.CustomerRepository;
import com.rewards.service.RewardsService;

@Service
public class RewardsServiceImpl implements RewardsService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}
}
