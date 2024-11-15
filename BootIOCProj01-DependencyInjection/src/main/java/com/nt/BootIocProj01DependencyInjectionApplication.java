package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01DependencyInjectionApplication {
	
	public BootIocProj01DependencyInjectionApplication() {
		System.out.println("BootIocProj01DependencyInjectionApplication:: 0-param constructor");
	}
	
	@Bean(name="dt")
	public   LocalDate  createLDate() {
		System.out.println("BootIocProj01DependencyInjectionApplication.createLDate()");
		return  LocalDate.now();
	}

	public static void main(String[] args) {
		System.out.println("BootIocProj01DependencyInjectionApplication.main()(start)");
		  //get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		//ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		// get target spring bean class obj ref
		SeasonFinder  finder=ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.method
		String resultMsg=finder.findSeason();
		//display the results
		System.out.println(resultMsg);
		//close container
		((ConfigurableApplicationContext) ctx).close();
		//ctx.close();
		System.out.println("BootIocProj01DependencyInjectionApplication.main() (end)");
	}

}
