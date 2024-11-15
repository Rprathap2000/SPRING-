package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.sbeans.PatientDetails;

@SpringBootApplication
@PropertySource("myfile1.properties")
public class BootIocProj07ValueAnntationSpelApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj07ValueAnntationSpelApplication.class, args);
		//get  PatientDetails class obj ref
		PatientDetails  details=ctx.getBean("pd",PatientDetails.class);
		//invoke the b.methods
	    System.out.println(details);
	    
	    //close the container
	    ((ConfigurableApplicationContext) ctx).close();
		
	}

}
