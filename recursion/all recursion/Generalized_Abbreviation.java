package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Generalized_Abbreviation {

	public static void main(String[] args) {
		String word = "word";
		System.out.println(generateAbbreviations(word));
	}

	public static List<String> generateAbbreviations(String word) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, new StringBuilder(), word, 0, 0);
		return ans;
	}

	private static void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
		int len = builder.length();
		if (i == word.length()) {
			if (k != 0) {
				builder.append(k);
			}
			ans.add(builder.toString());
		} else {
			backtrack(ans, builder, word, i + 1, k + 1);
			if (k != 0) {
				builder.append(k);
			}
			builder.append(word.charAt(i));
			backtrack(ans, builder, word, i + 1, 0);
		}
		builder.setLength(len);
	}
}
