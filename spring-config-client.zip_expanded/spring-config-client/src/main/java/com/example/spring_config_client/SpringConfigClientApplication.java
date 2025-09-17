package com.example.spring_config_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config-client/api")
@SpringBootApplication
public class SpringConfigClientApplication {

	@Autowired
	private Configs cfg;
	
	@GetMapping
	public String getCommonProps() {
		return cfg.getMsg();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}

}
