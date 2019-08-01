package SnS;

import java.util.Scanner;

public class subarray_with_given_sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int i = 0; i < test; i++) {
			int n = scn.nextInt();
			int sum = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scn.nextInt();
			}
			findSubarraySum(arr, sum);

		}
	}

	public static void findSubarraySum(int[] arr, int sum) {
		int curSum = arr[0];
		int stIdx = 0;
		for (int i = 1; i <= arr.length; i++) {

			while (curSum > sum && stIdx < i - 1) {
				curSum -= arr[stIdx];
				stIdx++;
			}

			if (curSum == sum) {
				System.out.println(stIdx + 1 + " " + (i));
				return;
			}
			if (i < arr.length)
				curSum += arr[i];
		}
		System.out.println(-1);
		return;
	}
}
