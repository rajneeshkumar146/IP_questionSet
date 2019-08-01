package InternQuestDP;

import java.util.Scanner;

public class Strange_Printer {
	public static int strangePrinter(String s) {
		if (s.length() == 0)
			return 0;

		int[][] dp = new int[s.length()][s.length()];

		for (int gap = 0; gap < s.length(); ++gap) {
			for (int i = 0, j = i + gap; j < s.length(); ++i, j++) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else {
					
					dp[i][j] = Integer.MAX_VALUE;
					int temp=(s.charAt(i)==s.charAt(j))?-1:0;
					for (int k = i + 1; k <= j; ++k) {
						int  res= dp[i][k - 1] + dp[k][j]+temp;
						dp[i][j] = Math.min(dp[i][j], res);
					}
				}
			}
		}

		return dp[0][s.length() - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int turns = strangePrinter(s);
		System.out.println(turns);

	}
	// abcabc

}
