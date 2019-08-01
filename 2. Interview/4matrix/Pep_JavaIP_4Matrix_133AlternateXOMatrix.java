package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_133AlternateXOMatrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int rows = scn.nextInt();
		int col = scn.nextInt();
		char[][] arr = new char[rows][col];
		fillmatrix(arr);
		printmatrix(arr);
	}

	private static void printmatrix(char[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void fillmatrix(char[][] arr) {
		int cmax = arr[0].length - 1;
		int cmin = 0;
		int rmax = arr.length - 1;
		int rmin = 0;
		int count = 0;
		boolean flag = true;
		while (count <= arr.length * arr[0].length) {
			int col = cmin;
			int row = rmin;
			for (row = rmin; row <= rmax && count <= arr.length * arr[0].length; row++) {
				if (flag == true) {
					arr[row][col] = 'X';

				} else {
					arr[row][col] = 'O';
				}
				count++;
			}
			cmin++;
			row = rmax;
			for (col = cmin; col <= cmax && count <= arr.length * arr[0].length; col++) {
				if (flag == true) {
					arr[row][col] = 'X';
				} else {
					arr[row][col] = 'O';
				}
				count++;
			}
			rmax--;
			col = cmax;
			for (row = rmax; row >= rmin && count <= arr.length * arr[0].length; row--) {
				if (flag == true) {
					arr[row][col] = 'X';
				} else {
					arr[row][col] = 'O';
				}
				count++;
			}
			cmax--;
			row = rmin;
			for (col = cmax; col >= cmin && count <= arr.length * arr[0].length; col--) {
				if (flag == true) {
					arr[row][col] = 'X';
				} else {
					arr[row][col] = 'O';
				}
				count++;
			}
			rmin++;

			flag = !flag;
			if(count==arr[0].length*arr.length) {
				break;
			}

		}
	}

}

/*
 Test cases:
3
2
------------------------
X X 
X X 
X X 

4
5
---------------------
X X X X X 
X O O O X 
X O O O X 
X X X X X 

6 6
-------------------
X X X X X X 
X O O O O X 
X O X X O X 
X O X X O X 
X O O O O X 
X X X X X X

source: https://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
 
 */
