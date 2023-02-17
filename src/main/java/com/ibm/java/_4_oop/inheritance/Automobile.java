package com.ibm.java._4_oop.inheritance;

public class Automobile extends Car {
	
	private String make;
	private String model;
	
	public Automobile(String make, String model, byte gear, float speed, Color color) {
		super(gear, speed, color);
		this.make = make;
		this.model = model;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	//	public void accelerate(float acceleration) {
	//		if (speed + acceleration > maxSpeed) {
	//			speed = maxSpeed;
	//		} else {
	//			speed += acceleration;
	//		}
	//		//		this.speed += acceleration;
	//	}
	
	public void accelerate() { //overloading
		System.out.println("Accelerate");
	}
	
	public void accelerate(float acceleration) {
		System.out.println("Accelerate from Automobile");
		if (getSpeed() + acceleration > maxSpeed) {
			setSpeed(maxSpeed);
		} else {
			setSpeed(getSpeed() + acceleration);
		}
	}
	
	
	public void changeGear(byte gearsChanged) {
		System.out.println("Change gear from Automobile");
		if (getGear() + gearsChanged < 1) {
			setGear((byte) 1);
		} else if (getGear() + gearsChanged > 5) {
			setGear((byte) 9);
		} else {
			setGear((byte) (getGear() + gearsChanged));
		}
	}
	
	public int getMaxLoad(){
		System.out.println("Get load from Automobile");
		return 3500;
	}
	
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
}
