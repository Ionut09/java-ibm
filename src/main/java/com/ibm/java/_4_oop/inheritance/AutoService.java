package com.ibm.java._4_oop.inheritance;


public class AutoService {
	
	public static void main(String[] args) {
		Color black = new Color("black");
		Automobile bmw = new Automobile("BMW", "Seria 5", (byte) 2, 20, black);
		System.out.println("bmw.getSpeed() = " + bmw.getSpeed());
		System.out.println("bmw.getGear() = " + bmw.getGear());
		System.out.println("Automobile.HAS_DOORS = " + Automobile.HAS_DOORS);
		
		//polymorphism --> reference audi: Car, obj Autombile
		Car car = new Automobile("VW", "Audi", (byte) 4, 60, black);
		car = new Automobile("BMW", "Seria 5", (byte) 2, 20, black);
		
		//not change
		car.accelerate(20);
		System.out.println("car.getSpeed() = " + car.getSpeed());
		System.out.println("car.getModel() = " + ((Automobile) car).getModel());
		
		Car simpleCar = new Car((byte) 3, 50, new Color("white"));
		simpleCar = car;
		simpleCar.changeGear((byte) 4);
		System.out.println("simpleCar.getGear() = " + simpleCar.getGear());
		

	}
}
