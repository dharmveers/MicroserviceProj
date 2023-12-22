package com.quize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizeServicesApplication.class, args);
	}

}
