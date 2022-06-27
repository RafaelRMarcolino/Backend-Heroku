package com.curso.rafael.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.rafael.service.DBServices;

@Configuration
@Profile("deve")
public class DeveConfig {

	@Autowired
	private DBServices dbServices;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public Boolean instantiateDataBase() throws ParseException{
		
		dbServices.instantiateDataBase();
		
		return true;		
	}
}
