package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sort_in_specific_order {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			oddEvenSort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void oddEvenSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				arr[i] *= -1;
			}
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				arr[i] *= -1;
			}
		}
	}
}
