package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.BlueDart;
import com.nt.sbeans.DTDC;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=
				 new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("-------------------------");
		
		DTDC dtdc=ctx.getBean("dtdc",DTDC.class);
		BlueDart bDart=ctx.getBean("bDart",BlueDart.class);
		
		
	/*	//get target class obj ref
		Flipkart  fpkt=ctx.getBean("fpkt",Flipkart.class);
	
	   // invoke the b.method
	   String resultMsg=fpkt.shopping(new String[] {"Dress","Bike","chain"}, 
			                                                         new double[] {5000.0, 120000.0,40000.0});
	   System.out.println(resultMsg);
	   //close the container 
	   ctx.close();*/
	}

}
