package InternQuestionDP;

public class Numbers_At_Most_N_Given_Digit_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atMostNGivenDigitSet(new String[] { "1", "3", "5", "7" }, 1233));
	}

	public static int atMostNGivenDigitSet(String[] cs, int num) {

		String s = num + "";
		int n = s.length();

		int dp[] = new int[n + 1];// dp[i] be the number of ways to write a valid number
									// if N became N[i], N[i+1], ....
		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			int sin = s.charAt(i) - '0';
			for (String sc : cs) {
				int cn = Integer.valueOf(sc);
				if (cn < sin) {
					dp[i] += Math.pow(cs.length, n - i - 1);
				} else if (cn == sin) {
					dp[i] += dp[i + 1];
				}
			}
		}
		for (int v : dp)
			System.out.print(v + " ");
		for (int i = 1; i < n; ++i)
			dp[0] += Math.pow(cs.length, i);
		return dp[0];
	}
}
