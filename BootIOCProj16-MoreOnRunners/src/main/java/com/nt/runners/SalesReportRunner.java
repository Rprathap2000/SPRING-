package com.nt.runners;

import java.util.Date;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(-2)
public class SalesReportRunner implements ApplicationRunner ,Ordered{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SalesReportRunner:: Sales Report on ::"+new Date());
		
		
		System.out.println("Non Option arg vlaues ::"+args.getNonOptionArgs());
		
		System.out.println("Option Arg  names and Values ::");
		 Set<String> optionArgNames=args.getOptionNames();
		 optionArgNames.forEach(name->{
			 System.out.println(name+" .....   "+args.getOptionValues(name));
		 });
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 10;
	}

}
