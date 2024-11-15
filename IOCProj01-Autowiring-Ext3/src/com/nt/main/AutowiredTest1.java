package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.A;
import com.nt.sbeans.B;

public class AutowiredTest1 {

	public static void main(String[] args) {
		//create IOC container 
		  AnnotationConfigApplicationContext  ctx=
				   new AnnotationConfigApplicationContext(AppConfig.class);
		  //get A class obj ref
		  A  a1=ctx.getBean("a1",A.class);
		  a1.display();
		  System.out.println("----------");
		  B  b1=ctx.getBean("b1",B.class);
		  b1.display();
		  

	}

}
