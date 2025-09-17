package com.example.spring_wallet_service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_wallet_service.beans.Account;
import com.example.spring_wallet_service.beans.Wallet;
import com.example.spring_wallet_service.client.AccountClient;

@Service
public class WalletServiceImpl {

	@Autowired
	private AccountClient accountClient;
	
	public Wallet addFunds(Account account) {
		double amount = account.getAmount();
		Wallet wallet = new Wallet();
		wallet.setFund(wallet.getFund() + amount);
		Account response = accountClient.debit(account);
		wallet.setAccount(response);
		return wallet;
	}
	
	public String remoteCalls() {
		//sends GET request to account-microservice/api/account/instance
		return accountClient.getInstancePort();
	}
}
