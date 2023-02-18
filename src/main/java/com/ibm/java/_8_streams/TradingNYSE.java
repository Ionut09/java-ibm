package com.ibm.java._8_streams;

import java.util.List;
import java.util.stream.Collectors;

public class TradingNYSE {
	
	/**
	 * 1. Find all transactions in the year 2011 and sort them by value  (small to high).
	 * 2. What are all the unique cities where the traders work?
	 * 3. Find all traders from Cambridge and sort them by name.
	 * 4. Return a string of all traders’ names sorted alphabetically.
	 * 5. Are any traders based in Milan?
	 * 6. Print all transactions’ values from the traders living in Cambridge.
	 * 7. What’s the highest value of all the transactions?
	 * 8. Find the transaction with the smallest value
	 */
	static Trader raoul = new Trader("Raoul", "Cambridge");
	static Trader mario = new Trader("Mario", "Milan");
	static Trader alan = new Trader("Alan", "Cambridge");
	static Trader brian = new Trader("Brian", "Cambridge");
	
	static List<Transaction> transactions = List.of(
		new Transaction(raoul, 2012, 1000),
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
	);
	
	public static void main(String[] args) {
		
		//		List<Integer> integers = List.of(1, 2, 3);
		System.out.println(getTransaction());
		System.out.println(getTraderNames());
	}
	
	//8. Find the transaction with the smallest value
	private static Transaction getTransaction() {
		return transactions.stream()
		                   .min((Transaction o1, Transaction o2) -> o1.getValue() - o2.getValue())
		                   .get(); // int compare(Transaction o1, Transaction o2);
	}
	
	//4. Return a string of all traders’ names sorted alphabetically.
	private static String getTraderNames() {
		return transactions.stream()
		                   //Trader apply(Transaction t);
		                   .map((Transaction t) -> t.getTrader())
		                   .map((Trader t) -> t.getName())
		                   .distinct()
		                   .sorted()
		                   .collect(Collectors.joining(","));
	}
	
}
