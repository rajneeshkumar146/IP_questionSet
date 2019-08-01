package InternQuestionDP;

public class Palindromic_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cps("abba"));
	}
	
	public static int cps(String s) {
		boolean[][] strg = new boolean[s.length()][s.length()];
		int p = 0;
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = i + g; j < s.length(); i++, j++) {
				if (g == 0) {
					strg[i][j] = true;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = true;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1]) {
						strg[i][j] = true;
					}
				}
				if (strg[i][j]) {
					p++;
				}
			}
		}
//		for (boolean v[] : strg) {
//			for (boolean z : v) {
//				if (z) {
//					System.out.print(z + "  ");
//				} else
//					System.out.print(z + " ");
//			}
//			System.out.println();
//		}
		return p;
	}
}
