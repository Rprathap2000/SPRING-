package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj15LayeredAppMiniProjectApplication {
	
	
	public static void main(String[] args) {
	   
		//get IOC container
		SpringApplication.run(BootIocProj15LayeredAppMiniProjectApplication.class, args);
				   
		 
	}//main

}//class
