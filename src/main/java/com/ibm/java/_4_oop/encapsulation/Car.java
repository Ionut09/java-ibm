package com.ibm.java._4_oop.encapsulation;

public class Car {
	
	public static final boolean HAS_DOORS = true;
	
	static byte numOfEngines = 1;
	static float maxSpeed = 200;
	
	private float fuelLevel = 0.1f;  //default 0.0
	private byte gear;              //default 0
	private Color color;             //default null
	private float speed = 1;        //default 0.0
	
	public Car(byte gear, float speed, Color color) {
		this.gear = gear;
		this.speed = speed;
		this.color = color;
	}
	
	public Car() {
	}
	
	public void accelerate(float acceleration) {
		if (speed + acceleration > maxSpeed) {
			speed = maxSpeed;
		} else {
			speed += acceleration;
		}
		//		this.speed += acceleration;
	}
	
	public void decelerate(float deceleration) {
		if (speed - deceleration <= 0) {
			speed = 0;
		} else {
			speed -= deceleration;
		}
	}
	
	public float getSpeed() {
		return speed;
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
