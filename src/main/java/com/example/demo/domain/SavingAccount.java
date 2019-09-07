package com.example.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SavingAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@SequenceGenerator(name="seq", initialValue=1001, allocationSize=5000)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int accountNumber;
	//private String accountType;
	//private String accountHolder;
	//private Date dateOpened;
	//private int branchCode;
	//private int ifscCode;
	private BigDecimal accountBalance;
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

	/*
	 * public String getAccountType() { return accountType; } public void
	 * setAccountType(String accountType) { this.accountType = accountType; } public
	 * String getAccountHolder() { return accountHolder; } public void
	 * setAccountHolder(String accountHolder) { this.accountHolder = accountHolder;
	 * } public Date getDateOpened() { return dateOpened; } public void
	 * setDateOpened(Date dateOpened) { this.dateOpened = dateOpened; } public int
	 * getBranchCode() { return branchCode; } public void setBranchCode(int
	 * branchCode) { this.branchCode = branchCode; } public int getIfscCode() {
	 * return ifscCode; } public void setIfscCode(int ifscCode) { this.ifscCode =
	 * ifscCode; }
	 */public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	


}
