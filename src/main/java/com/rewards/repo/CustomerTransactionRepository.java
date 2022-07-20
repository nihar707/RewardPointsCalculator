package com.rewards.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rewards.entity.CustomerTransaction;

public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Integer> {
	List<CustomerTransaction> findAllByTransactionDateBetweenAndCustomerId(Date startDate, Date endDate, Integer customerId);

}
