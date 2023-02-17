package com.ibm.java._5_strings;

public class BalancedBrackets {
	
	public static void main(String[] args) {
		String[] strings = {
			"286286",
			"    ",
			"",
			null,
			"()",
			"[()]", //->"[]" ->"" -> is balanced
			"{[()]()}", //{[]} -> {} ->
			"([{{[(())]}}])",
			"abc[](){}", // -> abc
			"{{[]()}}}}",
			"{[(])}" //-> "{[(])}" -> is not balanced
		};
		
		for (String string : strings) {
			System.out.println("string " + string + " is balanced = " + isBalanced(string));
		}
		
	}
	
	private static boolean isBalanced(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
			s = s.replace("()", "")
			     .replace("[]", "")
			     .replace("{}", "");
		}
		return s.isEmpty();
	}
}
