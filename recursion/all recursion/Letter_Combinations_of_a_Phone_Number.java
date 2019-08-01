package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {

	public static void main(String[] args) {

	}

	static String[] codes = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> ans = Combinations(digits);
		return ans;
	}

	private List<String> Combinations(String digits) {
		if (digits.length() == 0) {
			List<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}

		char ch = digits.charAt(0);
		String ros = digits.substring(1);
		List<String> rresult = Combinations(ros);

		String temp = codes[ch - '0'];
		List<String> tresult = new ArrayList<>();
		for (String val : rresult) {
			for (int i = 0; i < temp.length(); i++) {
				tresult.add(val + temp.charAt(i));
			}
		}
		return tresult;
	}
}
