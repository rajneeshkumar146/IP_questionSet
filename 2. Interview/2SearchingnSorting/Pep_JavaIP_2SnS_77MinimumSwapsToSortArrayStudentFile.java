-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of n distinct integers.
2. Print the count of minimum number of swaps required to sort the array.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_77MinimumSwapsToSortArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr1 = new int[scn.nextInt()];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}

		// Now we have to find number of swaps required to sort arr1. This would be our
		// answer.

		int count = minimumnumberofswapstosort(arr1);
		System.out.println(count);
	}

	private static int minimumnumberofswapstosort(int[] arr2) {

    //code to find minimum number of swaps required to sort the array

	}

	static class Pair implements Comparable<Pair> {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}

		public int compareTo(Pair o) {
			return this.value - o.value;
		}

	}
}

/*
 * Test cases:
 *
 * 5
  1 4 2 3 5
  ------------
	2

 *
 *
 * 8
5 1 2 6 3 4 7 8
  ----------------
 *4
 *
 * 6
 10 19 8 11 15 9
 --------------
 2
 *
 * Source:
 * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 */
