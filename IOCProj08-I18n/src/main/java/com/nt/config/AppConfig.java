package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
	
	@Bean(name="messageSource")  //fixed bean id
	public  ResourceBundleMessageSource  createRBMS() {
		ResourceBundleMessageSource  rbms=new ResourceBundleMessageSource();
		rbms.setBasename("com/nt/commons/App");
		return  rbms;
	}

}
