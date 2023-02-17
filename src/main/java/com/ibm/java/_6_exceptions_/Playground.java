package com.ibm.java._6_exceptions_;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Playground {
	
	static int counter = 0;
	
	public static void main(String[] args) throws IOException {
		
		//		System.out.println("Trying to parse a string");
		//		int i = tryParseInt("22");
		//		System.out.println("after dangerous code ==> i = " + i);
		
		tryParse("111"); //nu intra in incidenta lui try
		System.out.println("counter = " + counter); //2
		
		readFileUsingTryWithResources();
		readFileWithFinallyClosingResources();
		try {
			readFile();
		} catch (Exception e) { //checked exception
			//in situatia in care se face multi-wrapping al exceptiilor in cod
			//mai multe Caused by vor apare in stacktrace ==> ultimul denot root-cause-ul exceptiei
			throw new RuntimeException("Exception while reading file", e);
		}
	}
	
	private static int tryParse(String s) {
		counter++; //1
		try {
			--counter;
			int parseInt = Integer.parseInt(s);
			++counter;  //2
			return parseInt;
		} catch (IndexOutOfBoundsException ex) {
			counter += 4; //5
			return 0;
		}
	}
	
	private static void readFileUsingTryWithResources() {
		
		Path pathToFile = Path.of("/Users/ionut/workspace/trainings/java-ibm/pom.xml");
		
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException ex) {
			System.out.println("Exception while reading file");
		}
	}
	
	private static void readFileWithFinallyClosingResources() throws IOException {
		
		Path pathToFile = Path.of("/Users/ionut/workspace/trainings/java-ibm/pom.xml");
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(pathToFile);
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException ex) {
			System.out.println("Exception while reading file");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	private static void readFile() {
		
		List<String> strings = null;
		try {
			strings = Files.readAllLines(Path.of("/Users/ionut/workspace/trainings/java-ibm/pom.xml_oooo"));
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		for (String line : strings) {
			System.out.println(line.toUpperCase());
		}
	}
	
	private static int tryParseInt(String s) {
		try {
			System.out.println("inside try, before exception ");
			int parseInt = Integer.parseInt(s); // s==22 -> no exception
			System.out.println("inside try, after exception ");
			return parseInt;
		} catch (NumberFormatException ex) {
			//			ex.printStackTrace();
			System.out.println("Inside catch");
			return 0;
		}
	}
}
