package InternQuestionDP;

public class Minimum_Score_Triangulation_of_Polygon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minScoreTriangulation(new int[] { 1, 3, 1, 4, 1, 5 }));
	}

	public static int minScoreTriangulation(int[] a) {

		int n = a.length;
		int dp[][] = new int[n][n];

		for (int g = 2; g < n; g++) {
			for (int i = 0; i + g < n; i++) {
				int j = i + g;
				dp[i][j] = Integer.MAX_VALUE;
				for (int m = i + 1; m < j; m++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m][j] + a[i] * a[m] * a[j]);
				}
			}
		}
//		for (int c[] : dp) {
//			for (int v : c) 
//				System.out.print(v + " ");
//			System.out.println();
//		}
		return dp[0][n - 1];
	}
}
