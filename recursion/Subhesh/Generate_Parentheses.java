package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

	public static void main(String[] args) {
		
	}

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	private void backtrack(List<String> ans, String currString, int open, int close, int n) {
		if (currString.length() == 2 * n) {
			ans.add(currString);
			return;
		}
		if (open < n) {
			backtrack(ans, currString + "(", open + 1, close, n);
		}
		if (close < open) {
			backtrack(ans, currString + ")", open, close + 1, n);
		}
	}
}
