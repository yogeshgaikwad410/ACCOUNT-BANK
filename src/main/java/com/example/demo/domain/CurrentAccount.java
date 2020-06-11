package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CurrentTable")
public class CurrentAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int accountNumber;
	private double accountBalance;
	private String fullName;
	
	
	
	
		public CurrentAccount() {
		super();
			}
		
		
		public CurrentAccount(Long id, double d, double accountBalance, String fullName) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.accountBalance = accountBalance;
			this.fullName = fullName;
		}


		public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
