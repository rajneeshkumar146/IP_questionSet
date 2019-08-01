package SnS;

import java.util.Scanner;

public class sort_the_half_sorted {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scn.nextInt();
			}
			merge(arr, n);
		}
	}
	
	public static void merge(int[] arr,int n) {

		int mid = 0;
		for (int k = 0; k < n - 1; k++) {
			if (arr[k] > arr[k + 1]) {
				mid = k + 1;
				break;
			}
		}
		int i = 0;
		int j = mid;
		int k = 0;
		int[] temp = new int[n];
		while (i < mid && j < n) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i < mid) {
			temp[k++] = arr[i++];
		}

		while (j < n) {
			temp[k++] = arr[j++];
		}

		for (i = 0; i < n; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

}
