package com.ibm.java._4_oop.encapsulation;

public class AutoService {
	
	public static void main(String[] args) {
		Car myFirstJavaCar = new Car(); //default constructor
		
//		myFirstJavaCar.speed = -20.5f; //breaking business purpose
		
		myFirstJavaCar.accelerate(20);
		myFirstJavaCar.decelerate(10);
		myFirstJavaCar.decelerate(10);
		myFirstJavaCar.decelerate(10);
		myFirstJavaCar.decelerate(10);
		myFirstJavaCar.decelerate(10);
		
		System.out.println("myFirstJavaCar.getSpeed() = " + myFirstJavaCar.getSpeed());
		
		
	}
}
