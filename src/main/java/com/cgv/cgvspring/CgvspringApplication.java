package com.cgv.cgvspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cgv.*")
@SpringBootApplication
public class CgvspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgvspringApplication.class, args);
	}

}
