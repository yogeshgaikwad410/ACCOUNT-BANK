package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public CurrentAccount currentAccount(@Valid @RequestBody CurrentAccount currentAccount) {
		System.out.println("Created CurrentAccount Succesfully");
		return accountServiceImpl.createCurrentAccount(currentAccount);

	}

	@GetMapping("/findById/{id}")
	public Optional<CurrentAccount> findOne(@PathVariable(value = "id") Long id) {

		if (id != null) {
			return accountServiceImpl.findOneAccount(id);
		}
		return null;
	}

	@GetMapping("/findAllAccount")
	public List<CurrentAccount> findAll(CurrentAccount currentAccount) {
		return accountServiceImpl.findAll();
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable(value = "id") Long id) {
		accountServiceImpl.deleteAccountById(id);

	}

	@DeleteMapping("/deleteAll")
	public void deleteAll(CurrentAccount currentAccount) {
		accountServiceImpl.deleteAll();

	}
	@PutMapping(value="updateAccount/{id}")
	public CurrentAccount updateAccountD(@PathVariable("id") Long id, @RequestBody CurrentAccount currentAccount)
	{
		return accountServiceImpl.updateAccount(id, currentAccount);
	}
}
