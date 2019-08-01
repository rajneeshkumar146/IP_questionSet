package InternQuestDP;

import java.util.Scanner;

public class Wildcard_Matching {
	public static boolean isMatch(String s, String p) {
		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		char[] ss = s.toCharArray();
		char[] pp = p.toCharArray();
		dp[0][0] = true;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					continue;
				}
				if (i == 0) {
					dp[i][j] = (j > 0 && (pp[j - 1] == '*') && dp[i][j - 1]);
				} else {
					if (pp[j - 1] == '?' || pp[j - 1] == ss[i - 1]) {
						dp[i][j] = dp[i - 1][j - 1];
					} else if (pp[j - 1] == '*') {
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
					}

				}
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		return dp[s.length()][p.length()];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String text = scn.next();
		String Pattern = scn.next();
		System.out.println(isMatch(text, Pattern));

	}

}
