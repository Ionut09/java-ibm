package com.ibm.java._5_strings;

public class StringImmutability {
	
	public static void main(String[] args) {
		String s = ":Abcd"; //new String(":Abcd")
//		String str = s.toUpperCase();
		s = s.toUpperCase();
		s = s.replace(":","");
		System.out.println("s = " + s);//":Abcd"
	}
}
