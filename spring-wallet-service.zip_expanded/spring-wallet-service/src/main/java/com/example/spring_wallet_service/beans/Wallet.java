package com.example.spring_wallet_service.beans;

public class Wallet {
	private String name = "MyPay";
	private double fund = 5000;
	private Account account;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFund() {
		return fund;
	}
	public void setFund(double fund) {
		this.fund = fund;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
