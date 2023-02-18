package com.ibm.java._8_streams;

public class Lambdas {
	
	public static void main(String[] args) {
		
		//CheckTrait checkTrait = new AnimalChecker();
		//		CheckTrait checkTrait = new CheckTrait() {
		//			@Override
		//			public boolean test(Animal a) {
		//				return a.canHop();
		//			}
		//		};
		
		//boolean test(Animal a);  metoda din interfata
		CheckTrait checkTrait = (Animal s) -> s.canHop();
		checkTrait.test(new Dog());
		
		
	}
	
}
