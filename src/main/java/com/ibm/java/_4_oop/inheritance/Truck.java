package com.ibm.java._4_oop.inheritance;

public class Truck extends Car {
	
	public Truck(byte gear, float speed, Color color) {
		super(gear, speed, color);
	}
	
//	public int getMaxLoad() {
//		System.out.println("Gte max load from Truck");
//		return 40_000; //
//	}
	
	public void moves(){
		System.out.println("truck moves");
	}
	
	public void changeGear(byte gearsChanged) {
		System.out.println("Change gear from Truck");
		if (getGear() + gearsChanged < 1) {
			setGear((byte) 1);
		} else if (getGear() + gearsChanged > 5) {
			setGear((byte) 18);
		} else {
			setGear((byte) (getGear() + gearsChanged));
		}
	}
}
