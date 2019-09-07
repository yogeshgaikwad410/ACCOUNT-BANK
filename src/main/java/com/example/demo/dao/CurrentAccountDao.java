package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.CurrentAccount;


@Repository
public interface CurrentAccountDao extends JpaRepository<CurrentAccount,Long> {

	CurrentAccount findByAccountNumber(int accountNumber);	
}
