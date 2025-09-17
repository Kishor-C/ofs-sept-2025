package com.example.spring_wallet_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_wallet_service.beans.Account;
import com.example.spring_wallet_service.beans.Wallet;
import com.example.spring_wallet_service.business.WalletServiceImpl;

@RestController
@RequestMapping("/wallet/api")
public class WalletController {

	@Autowired
	private WalletServiceImpl walletService;
	
	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@GetMapping(path = "/remoteCall")
	public String test() {
		LOG.info("______ Wallet Microservice remoteCall to account service __________");
		return walletService.remoteCalls();
	}
	
	// using account details credit the amount to the wallet
	@PutMapping(path = "/addFunds", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addFundsToWallet(@RequestBody Account acc) {
		Wallet updatedWallet = walletService.addFunds(acc);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("message", "From wallet you can spend: "+updatedWallet.getFund());
		responseMap.put("accountBalance", updatedWallet.getAccount().getAmount());
		return ResponseEntity.ok(responseMap);
	}
	
	
}
