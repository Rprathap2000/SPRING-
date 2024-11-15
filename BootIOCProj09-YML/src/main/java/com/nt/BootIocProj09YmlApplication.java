package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.EmployeeDetails;

@SpringBootApplication
public class BootIocProj09YmlApplication {

	public static void main(String[] args) {
		 //get IOC container  
		ApplicationContext ctx= SpringApplication.run(BootIocProj09YmlApplication.class, args);
		//get spring bean class obj ref
		EmployeeDetails  details=ctx.getBean("emp",EmployeeDetails.class);
		System.out.println(details);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
