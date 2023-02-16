package com.ibm.java._1_operators;

public class Operators { //fara public e vizibila doar in pachetul unde e definita
	
	public static void main(String[] args) {
		
		String text = "hello" + " world";
		//	text = text + " number " + (5 + 5); // text = "hello world number 10"
		text = text + " number " + 5 + 5 + 5 + 6;
		System.out.println(text);
		
		System.out.println(6 + 6 + 3); //15
		System.out.println(6 + 6 + 3 + ""); //15
		System.out.println(6 + 6 * 3 + ""); //24
		System.out.println("result: " + 6 + 6 * 3 + ""); //"result:" + 6 + 18 + "" --> result: 618
		System.out.println("result: " + 6 + 6 * 3);      //"result:" + 6 + 18 + "" --> result: 618
		
		System.out.println("" + 6 + (6 + 3) + ""); //69
		System.out.println(6 + (6 + 3) + ""); //15
		
		int i = 2 / 3; //0
		System.out.println(2 / 3);//0
		System.out.println(2 / 3.0);//0.66666666666666
		
		//		Math --> clasa cu toate operatiile matematice
		
		double power = Math.pow(2, 3);
		double sin = Math.sin(Math.PI / 6);
		double sqrt16 = Math.sqrt(16);
		
		System.out.println("Math.sqrt(16) = " + sqrt16); //4.0
		System.out.println("Math.sqrt(16) = " + (int) sqrt16);  // 4
		
/*
	int -> Integer
	long -> Long
	double  -> Double


 */
		//wrapper classes : set de operatii utile pentru primitive
		String s = "55";
		int parsedInt = Integer.parseInt(s);
		int sum = 6 + parsedInt; //6 + s -> String
		
		int sum2 = Integer.parseInt(6 + s); //655
		System.out.println(sum2);
		
		String real = "1.24256";
		double parseDouble = Double.parseDouble(real); //1.24256
		
		Integer integer = 2;    //integer este o referinta catre un obiect de tip Integer
		int integer2 = 2;        //integer2 este o variabila primitiva de tip int
		
		//autoboxing
		//		Integer integer = new Integer(2);
		int sumUnBoxed = integer + 6; //integer devine int (unboxing)
		Integer sumBoxed = integer + 6; //integer devine int (unboxing) -> se face suma (int)-> suma devine Integer (boxing)
		
		long myLong = 1234;
		myLong = 123456789877L;
		System.out.println("myLong = " + myLong);//123456789877
		double x = 0.111d;
		System.out.println(x);
		
		byte b = 2; //like int
		
		char c = 'c'; //char asignat prin caracterul graphic
		c = 99; //char asignat prin code point-ul caracterului
		System.out.println("c + 0 = " + (c + 0)); //rezult de tip int: 99
		System.out.println((int) c);//99
		System.out.println(c);//c
		
		char f = (char) (c + 3); //f
		System.out.println("c + 3 = " + f);
		
		char unicodeChar = '\u007F'; //code in baza 16
		System.out.println("unicodeChar = " + unicodeChar);
		
		
		
	}
	
}
