package SearchingSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_73MinimumSwaps {
/*
*What
 *Given two arrays which have same values but in different order,
 *we need to make second array same as first array using minimum number of swaps.
 *
*HOW:
 *save the index of array A elements in array B i.e. if ith element of array A
 *is at jth position in array B, then we will make arrB[i] = j
 *This modified array represents distribution of array A element in array B
 *and our goal is to sort this modified array in minimum number of swaps
 *because after sorting only array B element will be aligned with array A elements.
*
*WHY
 *Problem reduces to reordering array index-wise
 *
*/
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
		// We can swap only arr2 elements
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], i);
		}

		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i])) {
				arr2[i] = map.get(arr2[i]);
			}
		}

		// Now we have to find number of swaps required to sort arr2. This would be our
		// answer.
		int count = minimumnumberofswapstosort(arr2);
		System.out.println(count);
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static int minSwaps(int[] arr) {

		int countSwap = 0;

		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				swap(arr, i, arr[i]);
				countSwap++;
			}
		}
		return countSwap;

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
