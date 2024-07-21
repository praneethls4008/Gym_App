package com.example.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.spring1","com.example.spring1.respository"})
public class RunAPI {

	public static void main(String[] args) {
		SpringApplication.run(RunAPI.class, args);
	}

}