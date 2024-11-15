package com.nt.comps;

public class OffRoadingCar implements ICar {

	@Override
	public void assemble() {
		System.out.println("OffRoading:: Thar Roxx assembling ");

	}

	@Override
	public void testDrive() {
		System.out.println("OffRoading.Thar Roxx   test drive");

	}

	@Override
	public void deliver() {
		System.out.println("OffRoading: Thar Roxx   delivery to Customer");

	}
	@Override
	public void drive() {
		System.out.println("LuxoryCar.Customer is  driving Thar Roxx car ");
		
	}

}
