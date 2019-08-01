package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_149BooleanMatrixQuestion {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];
		// the input array is row wise and column wise sorted matrix
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		boolean flagforrow1 = false;
		boolean flagforcol1 = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 1) {
				flagforcol1 = true;
				break;
			}
		}

		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == 1) {
				flagforrow1 = true;
				break;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					arr[0][j] = 1;
					arr[i][0] = 1;
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][0] == 1 || arr[0][j] == 1) {
					arr[i][j] = 1;
				}
			}
		}

		if (flagforcol1) {
			for (int i = 0; i < arr.length; i++) {
				arr[i][0] = 1;
			}
		}

		if (flagforrow1) {
			for (int i = 0; i < arr[0].length; i++) {
				arr[0][i] = 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
/*
Test cases:
	2 3
	0 0 0
	0 0 1
	-----------------
	0 0 1 
	1 1 1 

	
	4 4
	0 0 0 0
	0 1 0 0
	0 0 0 1
	0 0 0 0
	-----------------
	0 1 0 1 
	1 1 1 1 
	1 1 1 1 
	0 1 0 1
	
	
	
	4 4
	0 0 0 0
	0 1 0 1
	0 0 1 1
	0 0 0 0
	-----------------------
	0 1 1 1 
	1 1 1 1 
	1 1 1 1 
	0 1 1 1 	
	
	
	
	Source: https://www.geeksforgeeks.org/a-boolean-matrix-question/*/