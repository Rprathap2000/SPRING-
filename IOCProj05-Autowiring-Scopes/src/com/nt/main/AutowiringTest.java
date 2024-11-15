package com.nt.main;

import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;
import com.nt.ston.Printer;

public class AutowiringTest {

	public static void main(String[] args) {
		System.out.println("AutowiringTest.main()==start");
		
		//create IOC container 
		  AnnotationConfigApplicationContext  ctx=
				   new AnnotationConfigApplicationContext(AppConfig.class);
		  System.out.println("AutowiringTest:: IOC cotnainer creation completed");
		  
			/*  Printer prn1=ctx.getBean("prn1",Printer.class);
			  Printer prn2=ctx.getBean("prn1",Printer.class);
			  System.out.println(prn1.hashCode()+"...."+prn2.hashCode());
			  System.out.println("prn1==prn2?"+(prn1==prn2));
			  
			  Printer prn11=ctx.getBean("prn2",Printer.class);
			  Printer prn22=ctx.getBean("prn2",Printer.class);
			  System.out.println(prn11.hashCode()+"...."+prn22.hashCode());
			  System.out.println("prn11==prn22?"+(prn11==prn22));
			*/  
		  
		  // get target class obj
			/*  WishMessageGenerator generator1=ctx.getBean("wmg",WishMessageGenerator.class);
			  WishMessageGenerator generator2=ctx.getBean("wmg",WishMessageGenerator.class);
			  System.out.println(generator1.hashCode()+"...."+generator2.hashCode());
			  System.out.println("generator1==generator2"+(generator1==generator2));*/
		  
		  /*System.out.println("---------------------");
		  LocalTime  lt1=ctx.getBean("ltime",LocalTime.class);
		  LocalTime  lt2=ctx.getBean("ltime",LocalTime.class);
		  System.out.println(lt1.hashCode()+" ....  "+lt2.hashCode());
		  System.out.println("lt1===lt2?"+(lt1==lt2));
		  System.out.println("---------------------");*/
		  
			/* System.out.println("all bean  ids count::"+ctx.getBeanDefinitionCount());
			 System.out.println("all bean ids::"+Arrays.toString(ctx.getBeanDefinitionNames())); */
			 
			 
			 WishMessageGenerator  generator1=ctx.getBean("wmg",WishMessageGenerator.class);
			 System.out.println(generator1.generateMessage("raja"));
			 System.out.println("--------------------------");
			 WishMessageGenerator  generator2=ctx.getBean("wmg1",WishMessageGenerator.class);
			 System.out.println(generator2.generateMessage("raja"));
			 
				/* LocalTime  time=ctx.getBean("createLTime",LocalTime.class);
				 System.out.println(time);
				*/
		  
		  
		  
		
	}

}
