package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("a1")
public class A {
	//@Autowired
	private B  b;
	@Autowired
	public A(B b) {
		this.b=b;
		System.out.println("A:: 1-param constructor");
	}
	
	public void display() {
		System.out.println("from A");
	}
	

}
