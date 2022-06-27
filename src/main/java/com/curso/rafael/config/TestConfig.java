package com.curso.rafael.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.rafael.service.DBServices;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServices dbServices;
	
	@Bean
	public Boolean instantiateDataBase() throws ParseException{
		
		dbServices.instantiateDataBase();
		
		return true;		
	}
}
