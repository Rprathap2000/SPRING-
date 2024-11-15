package com.nt.factory;

import com.nt.comps.BlueDart;
import com.nt.comps.DTDC;
import com.nt.comps.Flipkart;
import com.nt.comps.ICourier;

public final class FlipkartFactory {
	
	public  static  Flipkart  getInstance(String courierType) {
		  ICourier  courier=null;
		  //create Courier object(dependent obj) based on the given courierTyoe
		  if(courierType.equalsIgnoreCase("dtdc")) 
			  courier=new DTDC();
		  else if(courierType.equalsIgnoreCase("bDart"))
			   courier=new BlueDart();
		  else 
			  throw new IllegalArgumentException("Invalid Courier type");
		  
		  //create  target class obj
		  Flipkart  fpkt=new Flipkart();
		  //assign  dependent class obj to target class obj
		  fpkt.setCourier(courier);
		return fpkt;
	}

}
