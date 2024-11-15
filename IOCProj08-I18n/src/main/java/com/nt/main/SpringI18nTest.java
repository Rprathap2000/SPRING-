package com.nt.main;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class SpringI18nTest {

	public static void main(String[] args) {
		//create IOC Container
		AnnotationConfigApplicationContext  ctx=
				  new  AnnotationConfigApplicationContext(AppConfig.class);
		//gather Locale  details from  enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Language code ::");
		String lang=sc.next();
		System.out.println("Enter Country code ::");
		String country=sc.next();
		//prepare Locale obj data
		Locale locale=new Locale(lang,country);
		//get the messages from  the Locale specfic properties file
		String msg1=ctx.getMessage("nit.welcome",new String[] {"raja"},"aa",locale);
		String msg2=ctx.getMessage("nit.bye",new String[] {},"bb",locale);
		String msg3=ctx.getMessage("nit.wishes",new String[] {},"cc",locale);
		
		//print the message
		System.out.println(msg1+"   "+msg2+"   "+msg3);
		
		//close the container
		ctx.close();
	}

}
