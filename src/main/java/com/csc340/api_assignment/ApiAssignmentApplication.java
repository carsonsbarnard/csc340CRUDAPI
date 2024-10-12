package com.csc340.api_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.csc340.api_assignment.model")
public class ApiAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAssignmentApplication.class, args);
	}

}
