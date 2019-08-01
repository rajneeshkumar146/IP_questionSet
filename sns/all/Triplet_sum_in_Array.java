package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class Triplet_sum_in_Array {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = scn.nextInt();
			int target = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			tripletSum(arr, target);
		}
	}

	public static void tripletSum(int[] arr, int target) {

		Arrays.sort(arr);
		int curSum = 0;
		int left, right;

		for (int i = 0; i < arr.length - 2; i++) {

			left = i + 1;
			right = arr.length - 1;

			while (left < right) {
				curSum = arr[left] + arr[right] + arr[i];
				if (curSum == target) {
					System.out.println(1);
					return;
				} else if (curSum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println(0);
		return;

	}
}
