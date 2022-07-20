package com.rewards.api;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.entity.Customer;
import com.rewards.service.RewardsService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RewardsController {

	
	@Autowired
	private RewardsService rewardsService;
	
	// fetches all customers data with transaction details, reward points by month, total points earned, total purchases made
	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsService.getAllCustomers();
	}
	
	// get customer data by ID  
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		Customer customer = rewardsService.getCustomerById(id);
		if (customer == null) return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
}




