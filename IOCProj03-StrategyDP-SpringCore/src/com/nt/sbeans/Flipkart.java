package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("fpkt")
public final class Flipkart {
   //HAS-A property
	@Autowired
	@Qualifier("dtdc")
	private ICourier  courier;
	
	//setter method for  assignment
	public void  setCourier(ICourier courier) {
		this.courier=courier;
	}
	
	// b.method
	public  String  shopping(String items[],double prices[]) {
		double   totalAmt=0.0;
		//calc bill amount
		for(double p:prices) {
			totalAmt=totalAmt+p;
		}
		//generate random number as the order id
		int oid=new Random().nextInt(30000);
		//use  dependent
		String dMsg=courier.deliver(oid);
		return  Arrays.toString(items)+" are purchased having prices"+Arrays.toString(prices)+" bill Amt::"+totalAmt+"....."+dMsg;
		
	}

}
