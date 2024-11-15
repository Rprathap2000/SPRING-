package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("b1")
public class B {
	//@Autowired
	private  A a;
	
	@Autowired
	public B(A  a) {
		this.a=a;
		System.out.println("B: 1-param construtor");
	}
	
	public void display() {
		System.out.println("from B");
	}

}
