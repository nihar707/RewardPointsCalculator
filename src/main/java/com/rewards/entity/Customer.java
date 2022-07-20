package com.rewards.entity;

import java.util.Set;
import java.util.stream.Collectors;
import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	// defines relation 1:N from customer to transaction object
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CustomerTransaction> transactions;
	
	@JsonInclude
	@Transient
	private Long totalRewardPoints;
	
	@JsonInclude
	@Transient
	private Double totalPurchases;
	
	@JsonInclude
	@Transient
	private Map<Month, Long> rewardPointsByMonth;
	
	public Customer() {
		super();
	}
	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<CustomerTransaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<CustomerTransaction> transactions) {
		this.transactions = transactions;
	}
	public Long getTotalRewardPoints() {
		if (transactions == null || transactions.isEmpty()) return 0l;
		//calculating sum of reward points earned
		return transactions.stream().map(tx -> tx.getPoints().intValue()).reduce(0, (a,b) -> a + b).longValue();
	}
	public Double getTotalPurchases() {
		if (transactions == null || transactions.isEmpty()) return 0d;
		// calculating sum of all purchases by the customer
		return transactions.stream().map(tx -> tx.getAmount().doubleValue()).reduce(0d, (a,b) -> a + b).doubleValue();
	}
	public Map<String, Long> getRewardPointsByMonth() {
		Map<String, Long> rewardPointsByMonth = new HashMap<>();
		if (transactions == null || transactions.isEmpty()) return null;
		// grouping by MONTH and calculating sum of reward points in each month
		rewardPointsByMonth = transactions.stream().collect(Collectors.groupingBy( tx -> Instant.ofEpochMilli(tx.getTransactionDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate().getMonth().name(), Collectors.summingLong(CustomerTransaction::getPoints)));
		
		return rewardPointsByMonth;
	}
	
	
	
}

