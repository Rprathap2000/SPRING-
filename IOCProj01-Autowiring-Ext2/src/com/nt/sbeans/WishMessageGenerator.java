//WishMessageGenerator.java (Target class)
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	  private  LocalTime  lt;  // HAS-Property (Composition)
	  private    LocalDate  ld;  //HAS- property
	  
	  
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-Arg constructor");
	}
	
	//parameterized constructor for constructor Injection (alt+shift+s,o)
	@Autowired(required = false)
	public WishMessageGenerator(LocalTime lt) {
		System.out.println("WishMessageGenerator::1-param constructor");
		this.lt = lt;
		}
	
	@Autowired(required = false)
	public WishMessageGenerator(LocalTime lt, LocalDate ld) {
		System.out.println("WishMessageGenerator:: 2-param constructor");
		this.lt = lt;
		this.ld = ld;
	}
	

	
	

	//b.method
	public  String   generateMessage(String  user) {
		System.out.println(lt+"......"+ld);
		
	   //	get current hour of the day
		int hour=lt.getHour();  //24 hours format
		//generate the wish  messages
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good Afternoon::"+user;
		else if(hour<20)
			return "Good Evening::"+user;
		else 
			 return "Good Night ::"+user;
		}

	

	

}
