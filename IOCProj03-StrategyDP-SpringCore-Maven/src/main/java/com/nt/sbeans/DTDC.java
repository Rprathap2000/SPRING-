package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dtdc")
//@Primary
public final class DTDC implements ICourier {
	
	public DTDC() {
		System.out.println("DTD: 0-arg constructor");
	}

	@Override
	public String deliver(int oid) {
		
		return  oid+"  order id   order is  assigned to DTDC for delivery";
				
	}

}
