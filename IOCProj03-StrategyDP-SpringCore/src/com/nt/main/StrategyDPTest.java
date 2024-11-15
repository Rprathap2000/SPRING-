package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=
				 new AnnotationConfigApplicationContext(AppConfig.class);
		//get target class obj ref
		Flipkart  fpkt=ctx.getBean("fpkt",Flipkart.class);
	
	   // invoke the b.method
	   String resultMsg=fpkt.shopping(new String[] {"Dress","Bike","chain"}, 
			                                                         new double[] {5000.0, 120000.0,40000.0});
	   System.out.println(resultMsg);
	   //close the container 
	   ctx.close();
	}

}
