package com.nt.main;

import com.nt.ston.Printer;

public class SingletonTest {

	public static void main(String[] args) {
		  // get the instances
		Printer  printer1=Printer.getInstance();
		Printer  printer2=Printer.getInstance();
		System.out.println(printer1.hashCode()+"    "+printer2.hashCode());
		System.out.println("------------------");
		System.out.println("printer1==printer2?"+(printer1==printer2));

	}

}
