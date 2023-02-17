package com.ibm.java._4_oop;

public class Car {
	
	public static final boolean HAS_DOORS = true;
	
	static byte numOfEngines = 1;
	
	float fuelLevel = 0.1f;  //default 0.0
	byte gear;              //default 0
	float speed = 1;        //default 0.0
	Color color;             //default null
	
	public Car() {
	}
	
	public Car(float fuelLevel, byte gear, float speed, Color color) {
		this.color = color;
		this.speed = speed;
		this.gear = gear;
		this.fuelLevel = fuelLevel;
	}
	
	public Car(byte gear, float speed, Color color) {
		this.gear = gear;
		this.speed = speed;
		this.color = color;
	}
	
	
}
