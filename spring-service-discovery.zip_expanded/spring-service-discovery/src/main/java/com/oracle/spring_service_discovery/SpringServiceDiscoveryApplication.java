package com.oracle.spring_service_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// this enables the program to act like Discovery Server / Service Discovery
@EnableEurekaServer
@SpringBootApplication
public class SpringServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceDiscoveryApplication.class, args);
	}

}
