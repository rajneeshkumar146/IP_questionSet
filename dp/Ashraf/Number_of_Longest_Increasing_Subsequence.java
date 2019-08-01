package InternQuestionDP;

public class Number_of_Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNumberOfLIS(new int[] { 1, 2, 22, 23, 9, 12 }));
	}

	public static int findNumberOfLIS(int[] nums) {
		int len = nums.length;
		if (len == 0 || len <= 1)
			return len;

		int[][] dp = new int[len][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		int FMAX = Integer.MIN_VALUE;
		for (int i = 1; i < len; i++) {
			int MAX = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j][0] + 1 >= MAX) {
					if (dp[j][0] + 1 > MAX) {
						dp[i][0] = dp[j][0] + 1;
						dp[i][1] = dp[j][1];
						MAX = dp[i][0];
					} else {
						dp[i][1] += dp[j][1];
					}
				}
			}
			if (MAX == Integer.MIN_VALUE) {
				MAX = 1;
				dp[i][0] = 1;
				dp[i][1] = 1;
			}
			FMAX = (FMAX > MAX) ? FMAX : MAX;
		}
		int sum = 0;
		for (int i = 0; i < len; i++)
			if (dp[i][0] == FMAX)
				sum += dp[i][1];
//		for (int v[] : dp) {
//			for (int c : v) {
//				System.out.print(c + " ");
//			}
//			System.out.println();
//		}
		return sum;
	}
}
