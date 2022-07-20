## RewardPoints-Calculator
### `Spring Boot- REST API`

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.   
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction  (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).   
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

- Make up a data set to best demonstrate the solution
- Check solution into GitHub



#### `Instructions for running the project on a local machine:`  

$ git clone https://github.com/nihar707/RewardPointsCalculator.git

$ mvn spring-boot: run

There are two apis:

/customers  returns all customers in the system with transaction details, total purchases, total reward points earned and points earned in each month.
/customers/{customerId} returns single customer object with his transactions, total purchases, total reward points earned and points earned in each month.
