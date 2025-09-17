package com.oracle.spring_account_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	// using slf4j logger instance
	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/instance")
	public String getPort() {
		LOG.info("______ Account Microservice getPort is called __________");
		return port;
	}
	
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
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getAccount(@PathVariable int id) {
		return ResponseEntity.ok(service.findAccount(id));
	}
	@GetMapping
	public ResponseEntity<Object> getAccounts() {
		return ResponseEntity.ok(service.findAllAccounts());
	}
}
