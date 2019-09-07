package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.SavingAccount;
import com.example.demo.service.impl.SavingServiceImpl;

@RestController
@RequestMapping("/savingA/c")
public class SavingController {

		@Autowired
		SavingServiceImpl accountServiceImpl;
		
		@PostMapping("/savingAccount")
		public SavingAccount savingAccount(@Valid @RequestBody SavingAccount savingAccount)
		{
			System.out.println("Created SavingAccount Succesfully");
			return accountServiceImpl.createSavingAccount(savingAccount);
			
		}
		
		@GetMapping("findAllAccount")
		public List<SavingAccount> findAll(SavingAccount savingAccount)
		{
			return accountServiceImpl.findAll();
		}
		
		@GetMapping("/findById/{id}")
		public Optional<SavingAccount> findOne(@PathVariable(value="id") Long id){
			
			if(id!=null)
			{
				return accountServiceImpl.findOne(id);
			}
			return null;
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<SavingAccount> updateSavingAccount(@PathVariable(value="id") Long id, @Valid @RequestBody SavingAccount savingAccount)
		{
			SavingAccount account=accountServiceImpl.getBySavingAccountId(id);
			
			if(account==null)
			{
				return new ResponseEntity<SavingAccount>(HttpStatus.NOT_FOUND);
			}
			account.setAccountBalance(savingAccount.getAccountBalance());
			SavingAccount account2 = accountServiceImpl.createSavingAccount(savingAccount);		
			return new ResponseEntity<SavingAccount>(HttpStatus.OK);
			
		}
		
		public ResponseEntity<SavingAccount> deleteSavingAccount(@PathVariable("id") Long id){
			
			SavingAccount ctd = accountServiceImpl.getBySavingAccountId(id);
			if(ctd==null)
			{
				return new ResponseEntity<SavingAccount>(HttpStatus.NOT_FOUND);
			}
			accountServiceImpl.deleteAccountById(id);
			return new ResponseEntity<SavingAccount>(HttpStatus.NO_CONTENT);
		}
	
}
