package InternQuestionDP;

public class Minimum_Cost_For_Tickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mincostTickets(int[] days, int[] costs) {
		
		int n = days[days.length - 1];
		// the dag is dp[i] = min{ dp[i-1] + cost[0], dp[i-7] + cost[1], dp[i-30] +
		// cost[2] }
		int[] dp = new int[n + 1];
		boolean[] travelDay = new boolean[n + 1];

		for (int i = 0; i < days.length; i++) {
			int day = days[i];
			travelDay[day] = true;
		}

		for (int i = 1; i < dp.length; i++) {
			if (travelDay[i] == false) {
				dp[i] = dp[i - 1];
				continue;
			}
			int one = dp[i - 1] + costs[0];
			int sev = dp[Math.max(0, i - 7)] + costs[1];
			int thir = dp[Math.max(0, i - 30)] + costs[2];

			dp[i] = Math.min(one, Math.min(sev, thir));
		}
		return dp[n];
	}

}
