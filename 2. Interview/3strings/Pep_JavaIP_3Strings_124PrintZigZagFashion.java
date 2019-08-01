package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_124PrintZigZagFashion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int n = scn.nextInt();
		getprob(str, n);
	}

	private static void getprob(String str1, int n) {
		// TODO Auto-generated method stub

		// creating str char array from string str1.
		char[] str = str1.toCharArray();
		if (n == 1) {
			System.out.println(str1);
			return;
		}
		// Find length of string
		int len = str1.length();
		// Create an array of strings for all n rows
		String arr[] = new String[n];
		// Initialize index for array of strings arr[].
		int row = 0;
		boolean down = true;

		// True if we are moving down in rows,
		// else false

		// Travers through given string
		for (int i = 0; i < len; ++i) {
			// append current character to current row
			if(arr[row]!=null)
			arr[row] += str[i];
			else {
				arr[row]=""+str[i];
			}
			// If last row is reached, change direction to 'up'
			if (row == n - 1)
				down = false;

			// If 1st row is reached, change direction to 'down'
			else if (row == 0)
				down = true;

			// If direction is down, increment, else decrement
			if (down == true) {
				row++;

			} else {
				row--;
			}
		}
		// Print concatenation of all rows
		for (int i = 0; i < n; i++)
			if(arr[i]!=null)
			System.out.print(arr[i]);
	}

}
/*
Test cases:
	abcdefgh
	2
	------------------------
	acegbdfh
	
	pecoding
	4
	------------------------
	pneigcdo
	

	geeksforgeeks
	3
	------------------------
	gsgsekfrekeoe
	
	
	
	Source: https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
 */