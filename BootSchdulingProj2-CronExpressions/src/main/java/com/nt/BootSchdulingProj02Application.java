package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchdulingProj02Application {

	public static void main(String[] args) {
		
		SpringApplication.run(BootSchdulingProj02Application.class, args);
		System.out.println("BootSchdulingProj02Application.main():::"+new Date());
		
		
	}

}
