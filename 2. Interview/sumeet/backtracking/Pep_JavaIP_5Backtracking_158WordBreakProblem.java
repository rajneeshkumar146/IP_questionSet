package interview.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_158WordBreakProblem {

	static HashSet<String> dictionary;
	static int length;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = Integer.parseInt(scn.nextLine());

		dictionary = new HashSet<>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}

		String ques = scn.next();
		length = ques.length();
		solve(ques, "", "", 0);
	}

	private static void solve(String ques, String ans, String prefix, int count) {
		if (ques.length() == 0) {
			// count is to count the spaces in answer
			// length is the original length of question
			if (count + length == ans.length()) {
				if (ans.length() > 0) {
					ans = ans.substring(0, ans.length() - 1);
				}
				
				System.out.print("(" + ans + ")");
			}
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		// If the prefix + ch is a word in dictionary, it can be used in sentence
		if (dictionary.contains(prefix + ch)) {
			solve(roq, ans + prefix + ch + " ", "", count + 1);
		}
		solve(roq, ans, prefix + ch, count);
	}
}
