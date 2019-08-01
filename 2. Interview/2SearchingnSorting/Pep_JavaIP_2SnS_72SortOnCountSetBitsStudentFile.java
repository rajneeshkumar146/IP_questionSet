-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of positive integers.
2. You have to sort the array in decreasing order of count of set bits
   in binary representations of array elements.
3. For integers having same number of set bits in their binary representation,
   sort according to their position in the original array.
4. Print the final sorted array.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_72SortOnCountSetBits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

    //code to print the required array

	}

	private static int countbits(int n) {

    //code to count bits in an integer

	}

	private static int getmax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	private static int countsetbits(int n) {

		//code to count number of setbits in an integer

}


/*
Test cases:

5
1 3 6 10 15
--------------
15 3 6 10 1

4
2 1 6 5
----------------
5 6 1 2

6
10 19 8 11 15 9
--------------
15 11 19 9 10 8

Source: https://www.geeksforgeeks.org/sort-array-according-count-set-bits/
*/
