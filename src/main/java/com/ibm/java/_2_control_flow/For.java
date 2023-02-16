package com.ibm.java._2_control_flow;

public class For {
	
	public static void main(String[] args) {
		int[] arr = {23, -10, 33, 100, -50, 120}; //0 <> length -1
		//0   1    2    3    4   5
		
		int maxFromArray = getMaxFromArray(arr);
		System.out.println("maxFromArray = " + maxFromArray);
		int start = 20, end = 100;
		getPrimes(start, end);
		
		
	}
	
	static int getMaxFromArray(int[] input) {
		int max = input[0]; //val minim pt tipul tau de data java.lang.Integer.MIN_VALUE
		for (int i = 0; i <= input.length - 1; i++) {
			if (max < input[i]) {
				max = input[i];
			}
		}
		return max;
	}
	
	static void getPrimes(int start, int end) {
		for (int i = start; i <= end; i++) {
			if(isPrime(i)){
				System.out.println(i + " is prime");
			}
		}
	}
	
	//check if i is prime
	static boolean isPrime(int input){
		boolean prime = true; //i e prim
		for (int j = 2; j < input / 2; j++) {
			if (input % j == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
	
	static boolean isPrimeImproved(int input){
		for (int j = 2; j < input / 2; j++) {
			if (input % j == 0) {
				return false;
			}
		}
		return true;
	}
}
