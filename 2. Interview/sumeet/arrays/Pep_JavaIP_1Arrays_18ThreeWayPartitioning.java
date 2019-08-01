package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_18ThreeWayPartitioning {

	public static void main(String[] args) {
		// Hackerrank
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int lv = scn.nextInt();
		int hv = scn.nextInt();

		solve(arr, lv, hv);

	}

	private static void solve(int[] arr, int lv, int hv) {
		int lo = 0;
		int mid = 0;
		int hi = arr.length - 1;

		// 1. 0 to lo is smallest elements
		// 2. lo to mid is in-between elements
		// 3. mid to hi is unkown area
		// 4. arr.length - 1 to hi is largest elements
		while (mid <= hi) {
			if (arr[mid] < lv) {
				swap(arr, lo, mid);
				lo++;
				mid++;
			} else if (arr[mid] >= lv && arr[mid] <= hv) {
				mid++;
			} else {
				swap(arr, mid, hi);
				hi--;
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
