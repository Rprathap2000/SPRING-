package com.nt.ston;

public class Printer {
	private static  Printer   INSTANCE;   //ref variable  to hold that single object
   
	//private constructor
	private Printer() {
		System.out.println("Printer:0-arg constructor");
	}
	
	//static  factory method having singleton logic
	public static   Printer  getInstance() {
		if(INSTANCE==null)
			INSTANCE=new Printer();
		
		return  INSTANCE;
	}
	
	//b.method
	public  void  print(String data) {
		System.out.println(data);
	}
}
