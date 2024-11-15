package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bDart")
public final class BlueDart implements ICourier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-arg constructor");
	}

	@Override
	public String deliver(int oid) {
		
		return  oid+"  order id   order is  assigned to BlueDart for delivery";
				
	}

}
