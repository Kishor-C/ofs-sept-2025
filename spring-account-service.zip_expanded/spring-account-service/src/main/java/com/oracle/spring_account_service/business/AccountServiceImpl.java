package com.oracle.spring_account_service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.spring_account_service.dao.AccountRepository;
import com.oracle.spring_account_service.entity.Account;

@Service
public class AccountServiceImpl {
	@Autowired
	private AccountRepository accountDao;
	@Transactional
	public Account createAccount(Account account) {
		return accountDao.save(account);
	}
	@Transactional
	public Account debitAmount(int accountNo, double amount) {
		Account found = accountDao.findById(accountNo).get();
		double balance = found.getAmount();
		balance = balance - amount;
		found.setAmount(balance);
		return found;
	}
	public List<Account> findAllAccounts() {
		return accountDao.findAll();
	}
	public Account findAccount(int id) {
		return accountDao.findById(id).get();
	}
}
