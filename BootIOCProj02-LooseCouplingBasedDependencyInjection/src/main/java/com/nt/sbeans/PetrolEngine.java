//PetrolEngine.java
package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pEngine")
@Lazy(true)
public final class PetrolEngine implements IEngine {
	
	public PetrolEngine() {
		System.out.println("PetrolEngine:: 0-arg constructor");
	}

	@Override
	public void startEngine() {
	  System.out.println("PetrolEngine.startEngine() --Engine started");
	}

	@Override
	public void stopEngine() {
		 System.out.println("PetrolEngine.endEngine() --Engine stopped");
	}

}
