package com.ibm.java._6_exceptions_;

public class MyCustomUncheckedExc extends RuntimeException {
	
	public MyCustomUncheckedExc(String message) {
		super(message);
	}
	
	public MyCustomUncheckedExc(String message, Exception cause) {
		super(message, cause);
	}
}
