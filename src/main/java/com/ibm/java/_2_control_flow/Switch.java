package com.ibm.java._2_control_flow;

import java.util.Scanner;

public class Switch {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first number: ");
		double first = scanner.nextDouble();
		System.out.println("Enter second number: ");
		double second = scanner.nextDouble();
		System.out.println("Enter operation: ");
		String operation = scanner.next();
		calculator(first, second, operation);
	}
	
	private static void calculator(double first, double second, String operation) {
		double result = 0;
		switch (operation) {
			case "+": {
				result = first + second;
				break; //daca nu punem break avem fallthrough = se executa toate case-urile dupa primul match
			}
			case "-": {
				result = first - second;
				break;
			}
			case "*": {
				result = first * second;
				break;
			}
			case "/": {
				result = first / second;
				break;
			}
			case "^": {
				result = Math.pow(first, second);
				break;
			}
			default:
				System.out.println("Bad operation. Please enter one of: +,-,*,/,^");
		}
		System.out.print(first + operation + second + " = " + result);
	}
}
