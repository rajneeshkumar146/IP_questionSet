package InternQuestionDP;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	public static int minCostClimbingStairs(int[] cost) {

		int dp[] = new int[cost.length + 1];
		if (cost.length >= 1) {
			dp[0] = cost[0];
			dp[1] = cost[1];
		}
		for (int i = 2; i < cost.length; i++)
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
		dp[dp.length - 1] = Math.min(dp[dp.length - 3], dp[dp.length - 2]);
		return dp[dp.length - 1];
	}
}
