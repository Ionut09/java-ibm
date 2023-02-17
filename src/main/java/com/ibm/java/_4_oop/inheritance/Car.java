package com.ibm.java._4_oop.inheritance;

/*
   Definiti o metoda in Car pe care sa o suprascriem in Autombile si intr-o alta clasa Truck
   
   getMaxLoad();
   
    Test code:
	Car myCar = new Automobile();
	myCar = new Truck();
	myCar.getMaxLoad();
 */
public class Car {
	
	public static final boolean HAS_DOORS = true;
	
	static byte numOfEngines = 1;
	static float maxSpeed = 200;
	
	private float fuelLevel = 0.1f;  //default 0.0
	private byte gear;              //default 0
	private Color color;             //default null
	private float speed = 1;        //default 0.0
	
	public Car(byte gear, float speed, Color color) {
		System.out.println("in superclass constructor ");
		this.gear = gear;
		this.speed = speed;
		this.color = color;
	}
	
	public void accelerate(float acceleration) {
		System.out.println("Accelerate from Car");
		if (speed + acceleration > maxSpeed) {
			speed = maxSpeed;
		} else {
			speed += acceleration;
		}
	}
	
	public void changeGear(byte gearsChanged) {
		System.out.println("Change gear from Car");
		if (gear + gearsChanged < 1) {
			gear = 1;
		} else if (gear + gearsChanged > 5) {
			gear = 5;
		} else {
			gear += gearsChanged;
		}
	}
	
	
	
	
	public void setGear(byte gear) {
		this.gear = gear;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	protected void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getFuelLevel() {
		return fuelLevel;
	}
	
	public byte getGear() {
		return gear;
	}
	
	public Color getColor() {
		return color;
	}
}
