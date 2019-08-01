package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_14searchInSortedAndRotated {
	public static void main(String[] args) {
		// Geeks
		/*
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int tar = scn.nextInt();

			System.out.println(solve(arr, tar));
		}
		*/
		// Hackerrank
		
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int tar = scn.nextInt();

		System.out.println(solve(arr, tar));
		
	}

	// find pivot
	// search in first half
	// search in second half
	private static int solve(int[] arr, int key) {
		if (arr.length == 0) {
			return -1;
		}
		int pivot = findPivot(arr, 0, arr.length - 1);

		// ei not inclusive
		int fifhalf = Arrays.binarySearch(arr, 0, pivot + 1, key); 
		if (fifhalf >= 0) {
			return fifhalf;
		} else {
			// si inclusive
			// binarysearch returns -8 (- * the spot to insert missing value)
			int fishalf = Arrays.binarySearch(arr, pivot + 1, arr.length, key); 
			return fishalf >= 0 ? fishalf : -1; 
		}
	}

	// pivot is the element for which previous and next both element are smaller
	// if mid is smaller than lo, pivot lies in first half otherwise second half
	private static int findPivot(int[] arr, int lo, int hi) {
		if(lo == hi){ // single element array case
			return lo;
		}
		
		int mid = (lo + hi) / 2;
		int prev = (mid - 1 + arr.length) % arr.length;
		int next = (mid + 1) % arr.length;
		if (arr[mid] > arr[prev] && arr[mid] > arr[next]) {
			return mid; // pivot found
		} else if (arr[mid] < arr[lo]) {
			return findPivot(arr, lo, prev); // pivot in first half
		} else {
			return findPivot(arr, next, hi); // pivot in second half
		}
	}
}
