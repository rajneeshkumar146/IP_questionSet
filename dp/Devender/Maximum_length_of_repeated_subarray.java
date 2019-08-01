package dp;

public class Maximum_length_of_repeated_subarray {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4,2, 1 };
		int[] B = { 3, 2, 1, 2, 3,4 };
		System.out.println(func(A, B));
	}

	public static int func(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];// stores upto this
															// index length of
															// maximum match
															// subarray
		int moveona = 1;
		int moveonb = 1;
		int ans = 0;
		while (moveona <= A.length) {
			moveonb=1;
			while (moveonb <= B.length) {
				if (A[moveona - 1] == B[moveonb - 1]) {
					dp[moveona][moveonb] = dp[moveona - 1][moveonb - 1] + 1;
				}
				ans = Math.max(dp[moveona][moveonb], ans);
				moveonb++;
			}
			moveona++;
		}
		return ans;
	}
}
