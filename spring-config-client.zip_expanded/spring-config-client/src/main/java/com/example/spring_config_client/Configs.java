package com.example.spring_config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope // this is required to detect the changes in the configuration
public class Configs {

	@Value("${message}")
	private String msg;
	
	public String getMsg() {
		return msg;
	}
}
