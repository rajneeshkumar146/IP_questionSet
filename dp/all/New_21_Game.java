package InternQuestionDP;

public class New_21_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new21Game(21, 17, 10));
	}

	public static double new21Game(int N, int K, int W) {

		double dp[] = new double[N + W + 1];

		for (int i = K; i <= N; i++)
			dp[i] = 1.0;
		for (int i = N + 1; i < dp.length; i++)// both having no moves
			dp[i] = 0;

		double s = Math.min(N - K + 1, W);// for k-1

		for (int i = K - 1; i >= 0; i--) {
			dp[i] = s / W;
			double sm1 = s + dp[i] - dp[i + W];
			s = sm1;
		}
		return dp[0];
	}
}
