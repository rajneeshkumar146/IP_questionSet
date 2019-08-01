package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_24sort012 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	public static void solve(int[] arr) {
		int lo = 0;
		int mid = 0;
		int hi = arr.length - 1;

		while (mid <= hi) {
			if (arr[mid] == 0) {
				swap(arr, mid, lo);
				lo++;
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, hi);
				hi--;
			} else {
				mid++;
			}
		}

		printarray(arr);
	}

	private static void printarray(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static void swap(int[] arr, int fp, int sp) {
		int temp_var = arr[fp] ^ arr[sp];
		arr[fp] ^= temp_var;
		arr[sp] ^= temp_var;
	}

}
