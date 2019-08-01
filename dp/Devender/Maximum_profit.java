package dp;

import java.util.Scanner;

public class Maximum_profit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 1; t <= test; t++) {
			int k = scn.nextInt();
			int n = scn.nextInt();
			int []arr=new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(profit(arr, k));
		}
	}

	public static int profit(int[] price, int k) {
		int[][] dp = new int[k + 1][price.length + 1];

		// do not do any transaction write
		for (int t = 1; t <= k; t++) {
			for (int i = 1; i < price.length; i++) {
				int max = 0;
				for (int j = 0; j < i; j++) {
					max = Math.max(max, price[i] - price[j] + dp[t - 1][j]);
				}
				int v = dp[t][i - 1];

				int l = Math.max(max, v);

				dp[t][i] = l;
			}
		}
		return dp[k][price.length-1];
	}
}
