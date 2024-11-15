//WishMessageGenerator.java (Target class)
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("wmg")
@Service("wmg1")
@Scope("prototype")
public class WishMessageGenerator {
	@Autowired
	  private  LocalTime  lt;  // HAS-Property (Composition)
	@Autowired
	  private    LocalDate  ld;  //HAS- property
	  
	  
	
	private WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-Arg constructor");
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
