package InternQuestDP;

import java.util.Scanner;

public class Ugly_Number_2 {
	public static int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int f2 = 2, f3 = 3, f5 = 5;
		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(f2, f3), f5);
			dp[i] = min;
			if (f2 == min) {
				++i2;
				f2 = 2 * dp[i2];
			}
			if (f3 == min) {
				++i3;
				f3 = 3 * dp[i3];
			}
			if (f5 == min) {
				++i5;
				f5 = 5 * dp[i5];
			}
		}
		return dp[n - 1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(nthUglyNumber(n));

	}

}
