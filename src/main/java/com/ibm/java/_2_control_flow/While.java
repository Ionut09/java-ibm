package com.ibm.java._2_control_flow;

import java.util.Scanner;

public class While {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your number: "); //37268726
		int number = scanner.nextInt();
		isPalindrom(number);
	}
	
	static void isPalindrom(int number){
		int numberCopy = number;
		String digits = "";
		while (numberCopy != 0) {
			int digit = numberCopy % 10;
			numberCopy /= 10;
			digits += digit;
		}
		if (Integer.parseInt(digits) == number) {
			System.out.println("Number " + number + " is palindrom");
		} else {
			System.out.println("Number " + number + " is not palindrom");
		}
	}
}
