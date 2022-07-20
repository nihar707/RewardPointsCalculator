package com.rewards.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;


@Entity
@Table(name ="transaction_detail")
public class CustomerTransaction {
	

	@Id
	@GeneratedValue
	private Long id;
	// defines relation N:1 from transaction to customer object
	@JsonIgnore
	@ManyToOne
	@JoinColumn 
	private Customer customer;
	private Double amount;
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;

	@JsonInclude  
	@Transient    
	private Long points;
	
	
	public CustomerTransaction() {
		super();
	}
	public CustomerTransaction(Long id, Customer customer, Double amount, String description, Date date) {
		super();
		this.id = id;
		this.customer = customer;
		this.amount = amount;
		this.description = description;
		this.transactionDate = date;
	}

	public Long getPoints() {
		this.points = 0l;
		
		if (this.amount > 50 && this.amount <= 100) {
			this.points += (this.amount.intValue() - 50) * 1;
			
		} 
		
		if (this.amount > 100) {
			this.points += 50;  //1 point for every dollar spent over $50
			this.points += (this.amount.intValue() - 100) * 2;  //2 points for every dollar spent over $100
		}
		
		return this.points;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Override
	public String toString() {
		return String.format("CustomerTransaction [id=%s, customer=%s, amount=%s, description=%s, transactionDate=%s]", id, customer,
				amount, description, transactionDate);
	}
	
}


