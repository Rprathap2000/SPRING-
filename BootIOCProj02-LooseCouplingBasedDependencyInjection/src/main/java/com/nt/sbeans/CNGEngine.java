//DieselEngine.java
package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("cEngine")
@Lazy(true)
public final class CNGEngine implements IEngine {
	
	public CNGEngine() {
		System.out.println("CNGEngine:: 0-arg constructor");
	}

	@Override
	public void startEngine() {
	  System.out.println("CNGEngine.startEngine() --Engine started");
	}

	@Override
	public void stopEngine() {
		 System.out.println("CNGEngine.endEngine() --Engine stopped");
	}

}
