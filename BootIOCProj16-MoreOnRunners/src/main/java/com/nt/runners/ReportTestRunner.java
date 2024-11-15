package com.nt.runners;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-10)
//@Order
public class ReportTestRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ReportTestRunner::  Report on "+new Date());
		
		System.out.println("Command line args are ::"+Arrays.toString(args));
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 5;
	}

}
