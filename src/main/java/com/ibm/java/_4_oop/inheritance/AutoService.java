package com.ibm.java._4_oop.inheritance;


public class AutoService {
	
	public static void main(String[] args) {
		Automobile bmw = new Automobile();
		System.out.println("bmw.getSpeed() = " + bmw.getSpeed());
		System.out.println("bmw.getGear() = " + bmw.getGear());
		System.out.println("Automobile.HAS_DOORS = " + Automobile.HAS_DOORS);
	}
}
