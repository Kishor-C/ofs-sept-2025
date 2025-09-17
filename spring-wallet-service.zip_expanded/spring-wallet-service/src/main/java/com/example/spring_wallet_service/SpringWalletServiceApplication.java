package com.example.spring_wallet_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringWalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWalletServiceApplication.class, args);
	}

}
