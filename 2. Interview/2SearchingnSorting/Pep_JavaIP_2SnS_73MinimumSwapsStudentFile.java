
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given two arrays. Both contains same integers but in different order.
2. You have to make second array same as first array using minimum swaps.
3. Find the minimum number of swaps required to do it.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_73MinimumSwaps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr1 = new int[scn.nextInt()];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = scn.nextInt();
		}

    //code to print minimum number of swaps to make second array same as first array.

	}

	private static int minimumnumberofswapstosort(int[] arr2) {

     //code to find minimum number of swaps to sort an array

	}

	private static int countbits(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n >>= 1;
		}
		return count;
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
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n >>= 1;
		}
		return count;
	}

}

/*
 * Test cases:
 *
 * 4
2 4 8 6
4 2 8 6
---------------------
1

 *
 4
 2 1 6 5
 5 1 2 6
 ----------------
 2
 *
 * 6
 10 19 8 11 15 9
  10 15 8 19 11 9
 * --------------
 * 2
 *
 * Source:
 * https://www.geeksforgeeks.org/minimum-swaps-to-make-two-array-identical/
 */
