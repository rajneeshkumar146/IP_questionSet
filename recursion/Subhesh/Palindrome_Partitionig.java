package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitionig {

	public static void main(String[] args) {
		String s = "abccbabcbabcbc";
		System.out.println(partition(s));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		char[] chars = s.toCharArray();
		List<String> solution = new ArrayList<>();
		helper(0, chars, solution, result);
		return result;
	}

	private static void helper(int start, char[] chars, List<String> solution, List<List<String>> result) {
		if (start == chars.length) {
			result.add(new ArrayList<>(solution));
			return;
		}

		for (int i = start; i < chars.length; i++) {
			if (isValid(start, i, chars)) {// substring(start -> i) is Palindrome.
				String st = new String(chars, start, i - start + 1);
				solution.add(st);
				helper(i + 1, chars, solution, result);
				solution.remove(solution.size() - 1);
			}
		}
	}

	private static boolean isValid(int start, int end, char[] chars) {
		while (start < end) {
			if (chars[start++] != chars[end--]) {
				return false;
			}
		}
		return true;
	}
}
