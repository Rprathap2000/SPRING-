//AppConfig.java
package com.nt.config;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nt.ston.Printer;

@Configuration
@ComponentScan(basePackages = {"com.nt.sbeans","com.nt.ston"})
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig.0-arg constructor");
	}
	
	@Bean(name="ltime")
	@Scope("prototype")
	public   LocalTime createLTime() {
		System.out.println("AppConfig.createLTime()");
		return  LocalTime.now();
	}
	
	@Bean(name="ldate")
	public   LocalDate   createLDate() {
		System.out.println("AppConfig.createDate()");
		return LocalDate.now();
	}
	
	@Bean(name="prn1")
	@Scope("prototype")
	public  Printer  createPrinter1() {
		System.out.println("AppConfig.createPrinter1()");
		return  Printer.getInstance();
	}
	
	@Bean(name="prn2")
	@Scope("prototype")
	public  Printer  createPrinter2() {
		System.out.println("AppConfig.createPrinter2()");
		return  Printer.getInstance();
	}
	
	

}
