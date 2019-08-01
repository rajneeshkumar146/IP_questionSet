package dp;

import java.util.Scanner;

public class Maximum_sum_increasing_subsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int[] inc = maxsumincfunc(arr);
			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(inc[i], max);
			}
			System.out.println(max);
		}
	}

	public static int[] maxsumincfunc(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		return dp;
	}

}
