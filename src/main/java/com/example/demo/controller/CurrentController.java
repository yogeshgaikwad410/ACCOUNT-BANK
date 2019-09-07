package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CurrentAccountDao;
import com.example.demo.domain.CurrentAccount;
import com.example.demo.service.impl.CurrentServiceImpl;

@RestController
@RequestMapping("/currentA/c")
public class CurrentController {

	@Autowired
	CurrentServiceImpl accountServiceImpl;
	
	@Autowired
	CurrentAccountDao currentAccountDao;
	
	@PostMapping("/currentAccount")
	public CurrentAccount currentAccount(@Valid @RequestBody CurrentAccount currentAccount)
	{
		System.out.println("Created CurrentAccount Succesfully");
		return accountServiceImpl.createCurrentAccount(currentAccount);
		
	}
	
	@GetMapping("findAllAccount")
	public List<CurrentAccount> findAll(CurrentAccount currentAccount)
	{
		return accountServiceImpl.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public CurrentAccount findOne(@PathVariable(value="id") Long id){
		
		if(id!=null)
		{
			return accountServiceImpl.findOne(id);
		}
		return null;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CurrentAccount> updateCurrentAccount(@PathVariable(value="id") Long id, @Valid @RequestBody CurrentAccount currentAccount)
	{
		CurrentAccount account=accountServiceImpl.getByCurrentAccountId(id);
		
		if(account==null)
		{
			return new ResponseEntity<CurrentAccount>(HttpStatus.NOT_FOUND);
		}
		account.setAccountBalance(currentAccount.getAccountBalance());
		CurrentAccount account2 = accountServiceImpl.createCurrentAccount(account);		
		return new ResponseEntity<CurrentAccount>(HttpStatus.OK);
		
	}
	
	@PostMapping("deposit/{id}")
	public ResponseEntity<CurrentAccount> deposit(@PathVariable(value="id") Long id, @Valid @RequestBody CurrentAccount currentAccount,Double amount)
	{
		CurrentAccount account=accountServiceImpl.getByCurrentAccountId(id);
		
		if(account==null)
		{
			return new ResponseEntity<CurrentAccount>(HttpStatus.NOT_FOUND);
		}
		BigDecimal newBalance = (currentAccount.getAccountBalance().plus().add(new BigDecimal(amount)));
		currentAccount.setAccountBalance(newBalance);
		 currentAccountDao.save(currentAccount);
		return new ResponseEntity<CurrentAccount>(HttpStatus.ACCEPTED); 
	
	}

	
	public ResponseEntity<CurrentAccount> deleteCurrentAccount(@PathVariable("id") Long id){
		
		CurrentAccount ctd = accountServiceImpl.getByCurrentAccountId(id);
		if(ctd==null)
		{
			return new ResponseEntity<CurrentAccount>(HttpStatus.NOT_FOUND);
		}
		accountServiceImpl.deleteAccountById(id);
		return new ResponseEntity<CurrentAccount>(HttpStatus.NO_CONTENT);
	}
	
}
