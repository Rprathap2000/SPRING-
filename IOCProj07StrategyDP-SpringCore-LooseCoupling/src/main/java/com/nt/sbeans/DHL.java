package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dhl")
public final class DHL implements ICourier {
	
	public DHL() {
		System.out.println("DHL:: 0-arg constructor");
	}

	@Override
	public String deliver(int oid) {
		
		return  oid+"  order id   order is  assigned to DHL for delivery";
				
	}

}
