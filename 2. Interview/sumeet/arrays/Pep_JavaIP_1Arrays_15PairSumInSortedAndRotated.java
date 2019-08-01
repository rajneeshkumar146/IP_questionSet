package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_15PairSumInSortedAndRotated {

	public static void main(String[] args) {
		// Hackerrank
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int tar = scn.nextInt();

		solve(arr, tar);
	}

	// find pivot
	// Use meet in the middle with modular arithmetic
	private static void solve(int[] arr, int tar) {
		if (arr.length == 0) {
			return;
		}
		int pivot = findPivot(arr, 0, arr.length - 1);
		meetInMiddle(arr, pivot, tar);
	}

	// pivot is the element for which previous and next both element are smaller
	// if mid is smaller than lo, pivot lies in first half otherwise second half
	private static int findPivot(int[] arr, int lo, int hi) {
		if (lo == hi) { // single element array case
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

	private static void meetInMiddle(int[] arr, int pivot, int tar) {
		int left = (pivot + 1) % arr.length;
		int right = pivot % arr.length;

		while (true) {
			if (arr[left] + arr[right] < tar) {
				left = (left + 1) % arr.length;
			} else if (arr[left] + arr[right] > tar) {
				right = (right - 1 + arr.length) % arr.length;
			} else {
				System.out.println(arr[left] + " " + arr[right]);
				left = (left + 1) % arr.length;
				right = (right - 1 + arr.length) % arr.length;
			}

			// if both are on one side, left must be on the left to continue
			if ((left <= pivot && right <= pivot) || (left > pivot && right > pivot)) {
				if (left >= right) {
					break;
				}
			} else { // if both are on opposite sides, left must be on the right to continue
				if(right >= left){
					break;
				}
			}
		}
	}
}
