package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_41MinimumMergeOpsRequiredToCreatePalindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(solve(arr));
	}

	private static int solve(int[] arr) {
		int res = 0;

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] < arr[right]) {
				// left is smaller, to make it a palindrome, attack left side by merging
				left++;
				arr[left] += arr[left - 1];
				
				res++;
			} else if (arr[left] > arr[right]) {
				// right is smaller, to make it a palindrome, attack right side by merging
				right--;
				arr[right] += arr[right + 1];
				
				res++;
			} else {
				// extremities are equal, proceed to internal area
				left++;
				right--;
			}
		}

		return res;
	}

}
