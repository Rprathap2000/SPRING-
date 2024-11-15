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
	
	//setter methods for setter Injection (alt+shift+s,r)
	@Autowired
	private void setLt(LocalTime lt) {
		System.out.println("WishMessageGenerator.setLt()");
		this.lt = lt;
	}

	@Autowired
	private void setLd(LocalDate ld) {
		System.out.println("WishMessageGenerator.setLd()");
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
