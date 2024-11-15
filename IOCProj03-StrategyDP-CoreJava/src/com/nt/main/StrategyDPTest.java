package com.nt.main;

import com.nt.comps.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		//get Flipkart class obj
	   Flipkart  fpkt=FlipkartFactory.getInstance("Bdart");
	   // invoke the b.method
	   String resultMsg=fpkt.shopping(new String[] {"Dress","Bike","chain"}, 
			                                                         new double[] {5000.0, 120000.0,40000.0});
	   System.out.println(resultMsg);
	}

}
