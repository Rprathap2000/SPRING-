package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.sbeans.PersonInfo;
import com.nt.sbeans.TestInfo;

public class ValueAnnotationTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		
			//get Spring bena class obj ref
			PersonInfo info=ctx.getBean("pInfo",PersonInfo.class);
			System.out.println(info);
			
		/*	// get Environment  obj from the IOC container
			Environment  env=ctx.getEnvironment();
			System.out.println(" per.id key value is ::"+env.getProperty("per.id"));
			System.out.println(" os.name key value is ::"+env.getProperty("os.name"));
			System.out.println(" env obj class name::"+env.getClass());
			
			//get  spring bean class obj ref
			TestInfo  info1=ctx.getBean("tInfo",TestInfo.class);
			info1.displayData();*/
		
		
		
		
		//close the container
		ctx.close();

	}

}
