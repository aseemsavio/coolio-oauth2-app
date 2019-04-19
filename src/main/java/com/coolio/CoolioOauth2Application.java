package com.coolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoolioOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(CoolioOauth2Application.class, args);
	}

}
