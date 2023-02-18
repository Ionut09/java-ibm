package com.ibm.java._3_arrays;

import java.util.Arrays;
import java.lang.*;

public class ArraysEx {
	
	public static void main(String[] args) {
		//multi size arrays
		
		double[][] matrixWithEmptyCells = new double[4][4];
		double[][] matrixExplicit = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		printMatrixContent(matrixExplicit);
		System.out.println(Arrays.toString(matrixExplicit[2]));
		double start = 2.5;
		initializeMatrixContent(matrixWithEmptyCells, start);
		printMatrixContent(matrixWithEmptyCells);
		
	}
	
	private static void initializeMatrixContent(double[][] matrixWithEmptyCells, double start) {
		for (int i = 0; i <= matrixWithEmptyCells.length - 1; i++) {
			for (int j = 0; j <= matrixWithEmptyCells[i].length - 1; j++) {
				matrixWithEmptyCells[i][j] = start * 5.5;
			}
		}
	}
	
	private static void printMatrixContent(double[][] matrixExplicit) {
		for (double[] row : matrixExplicit) {
			for (double cell : row) {
				System.out.print(cell + "  ");
			}
			System.out.print("\n");
		}
	}
}
