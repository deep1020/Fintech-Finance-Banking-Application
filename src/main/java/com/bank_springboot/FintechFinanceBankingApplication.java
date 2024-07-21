package com.bank_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class FintechFinanceBankingApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
		return applicationBuilder.sources(FintechFinanceBankingApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(FintechFinanceBankingApplication.class, args);

	}

}
