package com.ibm.java._8_streams;

public class AnimalChecker implements CheckTrait{
	
	@Override
	public boolean test(Animal a) {
		return a.canHop();
	}
}
