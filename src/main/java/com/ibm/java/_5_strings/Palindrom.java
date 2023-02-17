package com.ibm.java._5_strings;

public class Palindrom {
	
	//sadas -> true, ywbdeuwyb -> false
	public static void main(String[] args) {
		String s1 = "sadas"; //primul caracter cu ultimul, al doilea cu penultimul...
		String s2 = "ywbdeuwyb";
		
		System.out.println("isPalindrom(s1) = " + isPalindrom(s1));
		System.out.println("isPalindrom(s2) = " + isPalindrom(s2));
		System.out.println("isPalindromWithStringBuilder(s1) = " + isPalindromWithStringBuilder(s1));
		System.out.println("isPalindromWithStringBuilder(s2) = " + isPalindromWithStringBuilder(s2));
		
	}
	
	private static boolean isPalindrom(String input) {
		boolean palindrom = true;
		for (int i = 0; i <= input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				palindrom = false;
			}
		}
		return palindrom;
	}
	
	private static boolean isPalindromWithStringBuilder(String input) {
		StringBuilder stringBuilder = new StringBuilder(input);
		String reversed = stringBuilder.reverse()
		                               .toString();
		
		return input.equals(reversed); //===
		
	}
	
}
