package com.nt.comps;

public class StandardCar implements ICar {

	@Override
	public void assemble() {
		System.out.println("StandardCar:: Maruthi -suzuki swift assembling");

	}

	@Override
	public void testDrive() {
		System.out.println("StandardCar.Maruthi suzuki swift   test drive");

	}

	@Override
	public void deliver() {
		System.out.println("StandardCar: Maruthi suzuki  swift   delivery to Customer");

	}
	
	@Override
	public void drive() {
		System.out.println("LuxoryCar.Customer is  driving Standard car ");
		
	}

}
