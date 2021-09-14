package com.todo.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
@Ena
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

}
