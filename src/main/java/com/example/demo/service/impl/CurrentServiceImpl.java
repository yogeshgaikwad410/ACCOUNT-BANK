package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CurrentAccountDao;
import com.example.demo.domain.CurrentAccount;

@Service
public class CurrentServiceImpl {

	private static int nextAccountNumber = 11223145;

	 @Autowired 
	 private CurrentAccountDao currentAccountDao;
	 
	  

	public CurrentAccount createCurrentAccount(CurrentAccount currentAccount) {
		currentAccount.setAccountNumber(accountGen());
		return currentAccountDao.save(currentAccount);
	}
	
	
	public List<CurrentAccount> findAll(){
		return currentAccountDao.findAll();
	}
	
	
	public CurrentAccount findOne(Long id){
		return currentAccountDao.getOne(id);
	}
	
	
	public CurrentAccount getByCurrentAccountId(Long id)
	{
		return currentAccountDao.getOne(id);
	}
	public CurrentAccount updateCurrentAccount(CurrentAccount currentAccount, Long id)
	{
		return currentAccountDao.save(currentAccount);
	}
	
	public void  deleteAccountById(Long id)
	{
		currentAccountDao.deleteById(id);
	}
	
	public void deleteAll()
	{
		currentAccountDao.deleteAll();
	}
	

	
	public CurrentAccount deposit(Double amount, CurrentAccount currentAccount)
	{
		
		BigDecimal newBalance = (currentAccount.getAccountBalance().plus().add(new BigDecimal(amount)));
		currentAccount.setAccountBalance(newBalance);
		return currentAccountDao.save(currentAccount);
	
	}
	
	/*
	 * // MANDATORY: Transaction must be created before.
	 * 
	 * @Transactional(propagation = Propagation.MANDATORY ) public void
	 * addAmount(Long id, double amount) CurrentAccount account = this.findById(id);
	 * if (account == null) { throw new
	 * BankTransactionException("Account not found " + id); } double newBalance =
	 * account.getBalance() + amount; if (account.getBalance() + amount < 0) { throw
	 * new BankTransactionException( "The money in the account '" + id +
	 * "' is not enough (" + account.getBalance() + ")"); }
	 * account.setBalance(newBalance);}
	 */
    
	
	private int accountGen() { 
		return ++nextAccountNumber; 
	}
	
	
	
	
}
