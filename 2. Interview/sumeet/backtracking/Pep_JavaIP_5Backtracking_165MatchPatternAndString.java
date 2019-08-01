package interview.backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_165MatchPatternAndString {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String ques = scn.nextLine();
		String pat = scn.nextLine();

		HashMap<Character, String> map = new HashMap<>();
		solve(ques, pat, map);
	}

	 
	private static void solve(String ques, String pat, HashMap<Character, String> map) {
		if (pat.length() == 0) { 
			if (ques.length() == 0) {
				System.out.println(map);
			}
			return;
		}
		
		char chpat = pat.charAt(0);
		String rop = pat.substring(1);

		// try assigning all prefixes to character
		if (map.containsKey(chpat) == false) {
			for (int i = 1; i <= ques.length(); i++) {
				String prefix = ques.substring(0, i);
				String roq = ques.substring(prefix.length());

				map.put(chpat, prefix);
				solve(roq, rop, map);
				map.remove(chpat);
			}
		} else {
			// if a pre-assigned character is met, but the question does not have same prefix upfront
			// abort mission.
			String prefixFromMap = map.get(chpat);
			String prefixFromQues = ques.length() >= prefixFromMap.length() ? 
									ques.substring(0, prefixFromMap.length()): "";
			if (prefixFromMap.equals(prefixFromQues)) {
				String roq = ques.substring(prefixFromQues.length());
				solve(roq, rop, map);
			}
		}
	}

}
