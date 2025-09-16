package com.oracle.spring_account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.spring_account_service.business.AccountServiceImpl;
import com.oracle.spring_account_service.dao.AccountRepository;
import com.oracle.spring_account_service.entity.Account;

@RestController
@RequestMapping("/account/api")
public class AccountController {

	@Autowired
	private AccountServiceImpl service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Object> createAccount(@RequestBody Account acc) {
		Account created = service.createAccount(acc);
		return ResponseEntity.ok(created);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> debit(@RequestBody Account acc) {
		Account updatedAcc = service.debitAmount(acc.getAccountNo(), acc.getAmount());
		return ResponseEntity.ok(updatedAcc);
	}
	@GetMapping
	public ResponseEntity<Object> getAccounts() {
		return ResponseEntity.ok(service.findAllAccounts());
	}
}
