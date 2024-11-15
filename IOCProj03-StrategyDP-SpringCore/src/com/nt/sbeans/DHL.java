package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dhl")
@Primary
public final class DHL implements ICourier {

	@Override
	public String deliver(int oid) {
		
		return  oid+"  order id   order is  assigned to DHL for delivery";
				
	}

}
