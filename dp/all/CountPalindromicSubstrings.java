
public class CountPalindromicSubstrings {
	public static void palindromicSubstring(String s) {
		String ans = "";
		int count = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int gap = 0; gap <= s.length() - 1; gap++) {
			for (int i = 0, j = i + gap; j <= dp[0].length - 1; i++, j++) {
				if (gap == 0)
					dp[i][j] = true;
				else if (gap == 1)
					dp[i][j] = s.charAt(i) == s.charAt(j);
				else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
						ans = s.substring(i, j + 1);
						count++;
					}
				}
			}
		}
		System.out.println(ans);
		System.out.println("Total Palindromic Substrings " + count);
	}
}
