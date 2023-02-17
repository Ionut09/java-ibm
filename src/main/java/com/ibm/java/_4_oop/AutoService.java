package com.ibm.java._4_oop;

public class AutoService {
	
	public static void main(String[] args) {
		Car myFirstJavaCar = new Car(); //default constructor
		myFirstJavaCar.numOfEngines = 0;
		Car mySecondJavaCar = new Car((byte) 2, 10, new Color());
		
//		Car.HAS_DOORS = false;
		System.out.println("myFirstJavaCar.HAS_DOORS = " + myFirstJavaCar.HAS_DOORS);
		System.out.println("Car.HAS_DOORS = " + Car.HAS_DOORS);
		
		System.out.println("myFirstJavaCar.gear = " + myFirstJavaCar.gear); //0
		System.out.println("mySecondJavaCar.gear = " + mySecondJavaCar.gear); //2
		
		System.out.println("myFirstJavaCar.speed = " + myFirstJavaCar.speed);   //1.0
		System.out.println("mySecondJavaCar.speed = " + mySecondJavaCar.speed); //10.0
		
		System.out.println("myFirstJavaCar.numOfEngines = " + myFirstJavaCar.numOfEngines);   //0
		System.out.println("mySecondJavaCar.numOfEngines = " + mySecondJavaCar.numOfEngines);   //0
		System.out.println("new Car().numOfEngines = " + new Car().numOfEngines);       //0
		System.out.println("Car.numOfEngines = " + Car.numOfEngines);                         //0
		
		mySecondJavaCar.speed = -20.5f; //breaking business purpose
		
	}
}
