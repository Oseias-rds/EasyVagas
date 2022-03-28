package com.exemplo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = RegisterUserController.class)
public class EasyVagasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyVagasApiApplication.class, args);
	}

}
