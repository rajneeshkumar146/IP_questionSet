package InternQuestionDP;

public class Ones_and_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
	}

	public static class strInfo {
		int zeroNum;
		int oneNum;
		String str;

		strInfo(String str) {
			this.str = str;
			int zero = 0;
			int one = 0;
			for (char c : str.toCharArray()) {
				if (c == '0') {
					zero++;
				} else {
					one++;
				}
			}
			this.zeroNum = zero;
			this.oneNum = one;
		}
	}

	public static int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String str : strs) {
			strInfo SI = new strInfo(str);
			for (int currM = m; currM >= SI.zeroNum; currM--) {//out of bound
				for (int currN = n; currN >= SI.oneNum; currN--) {
					dp[currM][currN] = Math.max(dp[currM][currN], dp[currM - SI.zeroNum][currN - SI.oneNum] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
