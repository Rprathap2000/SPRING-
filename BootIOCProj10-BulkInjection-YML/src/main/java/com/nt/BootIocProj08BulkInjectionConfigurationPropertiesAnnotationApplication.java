package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class BootIocProj08BulkInjectionConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		//get  IOC container
	   ApplicationContext ctx=SpringApplication.run(BootIocProj08BulkInjectionConfigurationPropertiesAnnotationApplication.class, args);
       //get Spring bean class obj ref
	   Company  company=ctx.getBean("comp",Company.class);
	  System.out.println(company);
	  
	  //close the container
	  ((ConfigurableApplicationContext) ctx).close();
	 
	}

}
