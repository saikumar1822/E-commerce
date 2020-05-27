package com.example.Ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class DemoAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long demoAccountNumber;
	private long demoAccountBalance;

	  @OneToOne(cascade = CascadeType.ALL) 
	  private User user;

	public Long getDemoAccountNumber() {
		return demoAccountNumber;
	}

	public void setDemoAccountNumber(Long demoAccountNumber) {
		this.demoAccountNumber = demoAccountNumber;
	}

	public long getDemoAccountBalance() {
		return demoAccountBalance;
	}

	public void setDemoAccountBalance(long demoAccountBalance) {
		this.demoAccountBalance = demoAccountBalance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
