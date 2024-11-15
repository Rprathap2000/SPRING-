package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchdulingProj01Application {

	public static void main(String[] args) {
		
		SpringApplication.run(BootSchdulingProj01Application.class, args);
		System.out.println("BootSchdulingProj01Application.main():::"+new Date()+"..."+Thread.currentThread().getName());
		
	}

}
