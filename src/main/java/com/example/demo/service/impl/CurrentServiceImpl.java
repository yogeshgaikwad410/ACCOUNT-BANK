package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
		
	public Optional<CurrentAccount> findOneAccount(Long id)
	{
		return currentAccountDao.findById(id);
	}
	

	public List<CurrentAccount> findAll(){
		
		return currentAccountDao.findAll();
	}

	public void  deleteAccountById(Long id)
	{
		currentAccountDao.deleteById(id);
	}
	
	public void deleteAll()
	{
		currentAccountDao.deleteAll();
	}
	
	
	public CurrentAccount updateAccount(Long id, CurrentAccount currentAccount)
	{
		currentAccount.setId(id);
		return currentAccountDao.save(currentAccount);
		
	}
		
	private int accountGen() { 
		return ++nextAccountNumber; 
	}

	
}
