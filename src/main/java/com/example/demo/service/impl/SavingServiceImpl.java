package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SavingAccountDao;
import com.example.demo.domain.SavingAccount;

@Service
public class SavingServiceImpl {

	private static int nextAccountNumber = 11223145;

	 @Autowired 
	 private SavingAccountDao savingAccountDao;
	 
	  
	public SavingAccount createSavingAccount(SavingAccount savingAccount) {
		savingAccount.setAccountNumber(accountGen());
		return savingAccountDao.save(savingAccount);
	}
	
	
	public List<SavingAccount> findAll(){
		return savingAccountDao.findAll();
	}
	
	
	public Optional<SavingAccount> findOne(Long id){
		return savingAccountDao.findById(id);
	}
	
	
	public SavingAccount getBySavingAccountId(Long id)
	{
		return savingAccountDao.getOne(id);
	}
	public SavingAccount updateSavingAccount(SavingAccount savingAccount, Long id)
	{
		return savingAccountDao.save(savingAccount);
	}
	
	public void  deleteAccountById(Long id)
	{
		savingAccountDao.deleteById(id);
	}
	
	public void deleteAll()
	{
		savingAccountDao.deleteAll();
	}
	

	private int accountGen() { 
		return ++nextAccountNumber; 
	}
}
