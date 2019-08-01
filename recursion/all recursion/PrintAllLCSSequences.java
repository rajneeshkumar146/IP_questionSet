package recursion;

public class PrintAllLCSSequences {

	public static void main(String[] args) {

		String str1 = "ASFHILMB";
		String str2 = "ADSILMGB";
		System.out.println(lcs(str1, str2));
		System.out.println(lcsMemoised(str1, str2, new int[str1.length() + 1][str2.length() + 1]));
	}

	public static int lcs(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}

		if (str1.charAt(0) == str2.charAt(0)) {
			String newStr1 = str1.substring(1);
			String newStr2 = str2.substring(1);
			int leftOver = lcs(newStr1, newStr2);
			return leftOver + 1;
		} else {
			String newStr1 = str1.substring(1);
			String newStr2 = str2.substring(1);
			int leftOver1 = lcs(str1, newStr2);
			int leftOver2 = lcs(newStr1, str2);
			return Math.max(leftOver1, leftOver2);
		}

	}

	public static int lcsMemoised(String str1, String str2, int[][] qb) {

		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}
		if (qb[str1.length()][str2.length()] != 0) {
			return qb[str1.length()][str2.length()];
		}

		if (str1.charAt(0) == str2.charAt(0)) {

			String newStr1 = str1.substring(1);
			String newStr2 = str2.substring(1);
			int leftOver = lcsMemoised(newStr1, newStr2, qb);
			qb[str1.length()][str2.length()] = leftOver + 1;
			return leftOver + 1;
		} else {

			String newStr1 = str1.substring(1);
			String newStr2 = str2.substring(1);
			int leftOver1 = lcsMemoised(newStr1, str2, qb);
			int leftOver2 = lcsMemoised(str1, newStr2, qb);
			qb[str1.length()][str2.length()] = Math.max(leftOver1, leftOver2);
			return Math.max(leftOver1, leftOver2);

		}

	}

}
