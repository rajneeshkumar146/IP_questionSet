package OrderStatsHeapHash;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_401SurpasserCountOfEachElement {
/**
 * Slightly reverse of counting inversions, for all i count no of j's such that
 * arr[i] < arr[j] and j > i.
 * For all arr[i] give a surpasser count.
 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		//Key : element, Value: surpasser count
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], 0);
		}

		mergeSort(arr, map, 0, arr.length - 1);
		System.out.println(map);
	}

	private static void mergeSort(int[] arr, HashMap<Integer, Integer> map, int i, int j) {
		if (i == j) {
			return;
		}
		int mid = (i + j) / 2;
		mergeSort(arr, map, i, mid);
		mergeSort(arr, map, mid + 1, j);
		merge(arr, map, i, mid + 1, j);

	}
	// count all surpassers in merge step
	private static void merge(int[] arr, HashMap<Integer, Integer> map, int i, int mid, int j) {

		int[] left = new int[mid - i];
		int[] right = new int[j - mid + 1];

		for (int i1 = 0; i1 < left.length; ++i1)
			left[i1] = arr[i + i1];
		for (int j1 = 0; j1 < right.length; ++j1)
			right[j1] = arr[mid + j1];

		int count = 0;
		int fp = 0;
		int sp = 0;
		int k = i;
		while (fp < left.length && sp < right.length) {
			if (left[fp] < right[sp]) {
				// these elements are all greater than left[fp], i.e surpass
				map.put(left[fp], map.get(left[fp]) + right.length - sp);
				arr[k] = left[fp];
				fp++;
			} else {
				arr[k] = right[sp];
				sp++;
			}
			k++;

		}

		while (fp < left.length) {
			arr[k] = left[fp];
			fp++;
			k++;
		}

		while (sp < right.length) {
			arr[k] = right[sp];
			sp++;
			k++;
		}

	}

}
/**
 * Test case :
 7
 2 7 5 3 0 8 1
 ```````````````````````
 4 1 1 1 2 0 0

 7
 1 2 3 4 5 6 7
 ```````````````````````
 6 5 4 3 2 1 0 
 * Source: https://www.geeksforgeeks.org/find-surpasser-count-of-each-element-in-array/
 */