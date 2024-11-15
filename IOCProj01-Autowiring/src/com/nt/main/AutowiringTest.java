package com.nt.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class AutowiringTest {

	public static void main(String[] args) {
		System.out.println("AutowiringTest.main()==start");
		
		//create IOC container 
		  AnnotationConfigApplicationContext  ctx=
				   new AnnotationConfigApplicationContext(AppConfig.class);
		  System.out.println("AutowiringTest:: IOC cotnainer creation completed");
		  
		 //get Target spring bean class obj ref
		  WishMessageGenerator  generator=ctx.getBean("wmg",WishMessageGenerator.class);
		/*  WishMessageGenerator  generator1=ctx.getBean("wmg",WishMessageGenerator.class);
		  WishMessageGenerator  generator2=ctx.getBean("wmg",WishMessageGenerator.class);
		  WishMessageGenerator  generator3=ctx.getBean("wmg",WishMessageGenerator.class);
		  System.out.println(generator.hashCode()+"   "+generator1.hashCode()+" "+generator2.hashCode()+"  "+generator3.hashCode());
		  System.out.println("generator==generator1?"+(generator==generator1));
		  System.out.println("generator1==generator2?"+(generator1==generator2));
		  System.out.println("generator2==generator3?"+(generator2==generator3)); */
		  	System.out.println("Target spring bean class obj ref is gathered");
		  //invoke the b.method
		  String msg=generator.generateMessage("raja");
		  //display the result
		  System.out.println("result is ::"+msg);
		  
		  //close the container
		  ctx.close();
		  
		  System.out.println("AutowiringTest.main()==> End");

	}

}
