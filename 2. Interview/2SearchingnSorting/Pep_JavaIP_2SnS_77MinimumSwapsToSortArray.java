package SearchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_77MinimumSwapsToSortArray {
/*
*What
 *Given an array find minimum number of swaps to sort array.
 *
*HOW
 *Map array elements to their indices in a HashMap
 *sort the array. Iterate over it, find the old value of correct element
 *from HashMap.Now each arr[i] contains the index where correct element was
 *present.Keep swapping till arr[i] != i, which means that element is at its
 *correct position
*WHY :
*Internally this code is working similarly to cycles code, it keeps on travelling
*cycle edges till we have completed one cycle.
*
*/

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static int minSwaps(int[] arr) {

		Map<Integer, Integer> oldIndices = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			oldIndices.putIfAbsent(arr[i], i);
		}
		Arrays.sort(arr);

		int countSwap = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = oldIndices.get(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				swap(arr, i, arr[i]);
				countSwap++;
			}
		}
		return countSwap;

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		while (test-- > 0) {

			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(minSwaps(arr));
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
