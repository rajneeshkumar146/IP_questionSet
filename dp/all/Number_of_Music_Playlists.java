package InternQuestionDP;

public class Number_of_Music_Playlists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1e9 + 7);
	}

	public int numMusicPlaylists(int N, int L, int K) {
		long[][] dp = new long[L + 1][N + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] += dp[i - 1][j - 1] * (N - j + 1);// n-j left songs
				dp[i][j] += dp[i - 1][j] * Math.max(0, j - K);
				dp[i][j] %= 1e9 + 7;
			}
		}
		return (int) dp[L][N];
	}
}
