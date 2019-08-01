package InternQuestionDP;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		String s = "abccbc";
		System.out.println(mcpss(s));
	}

	private static int mcpss(String s) {

		int[][] strg = new int[s.length()][s.length()];

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = i + g; j < s.length(); i++, j++) {
				if (g == 0) {
					strg[i][j] = 0;
				} else if (g == 1) {
					strg[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
				} else {
					if (s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == 0) {
						strg[i][j] = 0;
					} else {
						strg[i][j] = Integer.MAX_VALUE;
						for (int c = 1; c <= g; c++) {
							int lp = strg[i][i + c - 1];
							int rp = strg[i + c][j];
							strg[i][j] = Math.min(strg[i][j], lp + rp + 1);
						}
					}
				}
			}
		}
//		for(int v[] : strg) {
//			for(int c : v) {
//				System.out.print(c+" ");
//			}System.out.println();
//		}
		return strg[0][s.length() - 1];
	}
}