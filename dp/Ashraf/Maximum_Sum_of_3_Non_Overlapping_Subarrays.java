package InternQuestionDP;

import java.util.Arrays;

public class Maximum_Sum_of_3_Non_Overlapping_Subarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 1 }, 2);
	}

	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {

		int n = nums.length;
		int dp[] = new int[n - k + 1];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (i >= k) {
				sum -= nums[i - k];
			}
			if (i >= k - 1) {
				dp[i - (k - 1)] = sum;
			}
		}

		int lftbstind[] = new int[dp.length];
		int lbi = 0;
		for (int i = 0; i < lftbstind.length; i++) {
			if (dp[i] > dp[lbi]) {
				lbi = i;
			}
			lftbstind[i] = lbi;
		}

		int rgtbstind[] = new int[dp.length];
		int rbi = dp.length - 1;
		for (int i = dp.length - 1; i >= 0; i--) {
			if (dp[i] > dp[rbi])
				rbi = i;
			rgtbstind[i] = rbi;
		}

		int ans[] = new int[3];
		Arrays.fill(ans, -2);
		for (int i = k; i < dp.length - k; i++) {
			if (ans[0] == -2
					|| (dp[lftbstind[i - k]] + dp[i] + dp[rgtbstind[i + k]] > dp[ans[0]] + dp[ans[1]] + dp[ans[2]])) {
				ans[0] = lftbstind[i - k];
				ans[1] = i;
				if (dp[i + k] == dp[rgtbstind[i + k]])
					ans[2] = i + k;
				else
					ans[2] = rgtbstind[i + k];
			}
		}
//		for (int v : dp) {
//			System.out.print(v + " ");
//		}
//		System.out.println();
//		for (int v : lftbstind) {
//			System.out.print(v + " ");
//		}
//		System.out.println();
//		for (int v : rgtbstind) {
//			System.out.print(v + " ");
//		}
//		System.out.println();
//		for (int v : ans) {
//			System.out.print(v + " ");
//		}
		return ans;
	}

}
