package com.example.spring_wallet_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring_wallet_service.beans.Account;

@FeignClient("http://SPRING-ACCOUNT-SERVICE/account/api")
public interface AccountClient {

	@GetMapping("/instance")
	public String getInstancePort();
	
	@PutMapping
	public Account debit(@RequestBody Account acc);
}
