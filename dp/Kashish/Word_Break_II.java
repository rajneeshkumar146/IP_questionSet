package InternQuestDP;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Word_Break_II {
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dict) {
		return dfs(s, dict, new HashMap<>());
	}

	public static ArrayList<String> dfs(String s, ArrayList<String> dict, HashMap<String, ArrayList<String>> memo) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}
		ArrayList<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		int n = s.length();

		for (String w : dict) {
			if (s.startsWith(w)) {
				int end = w.length();
				if (end == n) {
					res.add(w);
				} else {
					ArrayList<String> sublist = dfs(s.substring(end), dict, memo);
					for (String item : sublist) {
						item = w + " " + item;
						res.add(item);
					}
				}
			}
		}

		memo.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = "pineapplepenapple";
		ArrayList<String> Dict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
		System.out.println(wordBreak(s, Dict));

	}

}
