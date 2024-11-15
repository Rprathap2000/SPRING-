package com.nt.comps;

public class LuxoryCar implements ICar {

	@Override
	public void assemble() {
		System.out.println("LuxoryCar:: Rolls-Royce assembling ");

	}

	@Override
	public void testDrive() {
		System.out.println("LuxoryCar.Rolls-Royce   test drive");

	}

	@Override
	public void deliver() {
		System.out.println("LuxoryCar: Rolls-Royce   delivery to Customer");

	}

	@Override
	public void drive() {
		System.out.println("LuxoryCar.Customer is  driving Rolls-Royce car ");
		
	}
}
