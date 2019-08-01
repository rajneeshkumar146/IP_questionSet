package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sorting_all_array_elements_except_one {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int i = 0; i < test; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scn.nextInt();
			}
			int idx = scn.nextInt();

			sortByLeavingOne(arr, idx);
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();

		}
	}

	public static void sortByLeavingOne(int[] arr, int idx) {

		int temp = arr[idx];
		arr[idx] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;

		Arrays.sort(arr, 0, arr.length - 1);
		int num = arr[arr.length - 1];
		for (int i = arr.length - 1; i > idx; i--) {
			arr[i] = arr[i - 1];
		}

		arr[idx] = num;
	}
}
