package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Letter_case_Permutation {

	public static void main(String[] args) {
		String st = "0";
		System.out.println(letterCasePermutation1(st));
	}

	public static List<String> letterCasePermutation1(String S) {
		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder(S);
		helper(sb, ans, 0);
		return ans;
	}

	private static void helper(StringBuilder sb, List<String> ans, int cpos) {
		if (cpos == sb.length()) {
			StringBuilder bres = new StringBuilder();
			bres = sb;
			String st1 = bres.toString();
			ans.add(st1);
			return;
		}
		if (sb.charAt(cpos) > '9' || sb.charAt(cpos) < '0') {
			char ch = sb.charAt(cpos);

			helper(sb, ans, cpos + 1);
			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 'a' + 'A');
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - 'A' + 'a');
			}
			sb.setCharAt(cpos, ch);
			helper(sb, ans, cpos + 1);
		} else {
			helper(sb, ans, cpos + 1);
		}
	}
}
