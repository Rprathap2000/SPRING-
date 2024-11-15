//DieselEngine.java
package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dEngine")
@Lazy(true)
public final class DieselEngine implements IEngine {
	
	public DieselEngine() {
		System.out.println("DieselEngine::0-arg constructor");
	}

	@Override
	public void startEngine() {
	  System.out.println("DieselEngine.startEngine() --Engine started");
	}

	@Override
	public void stopEngine() {
		 System.out.println("DieselEngine.endEngine() --Engine stopped");
	}

}
