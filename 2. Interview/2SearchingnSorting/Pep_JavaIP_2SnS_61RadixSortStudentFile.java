-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of positive integers.
2. You have to print sorted array.
   Time Complexity : 0(n * d),where n is the number of integers in array, and
	 d is the number of digits in the largest number of array.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_61RadixSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		radixsort(arr);
	}

	private static void radixsort(int[] arr) {

		//write code


		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static void countingsort(int[] arr, int exp) {
		//utility function
	}

	private static int getmax(int[] arr) {
		//utility function
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}

/*
 Test cases:
 8
170 45 75 90 802 24 2 66
-------------------------------
 2 24 45 66 75 90 170 802

 8
170 45 75 90 803 24 2 67
-------------------------------
 2 24 45 67 75 90 170 803

 8
170 45 75 99 803 24 2 68
-------------------------------
 2 24 45 68 75 99 170 803

 Source: https://www.geeksforgeeks.org/radix-sort/
 */
