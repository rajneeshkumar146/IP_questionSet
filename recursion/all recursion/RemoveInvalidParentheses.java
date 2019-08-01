package recursion;
import java.util.HashSet;
import java.util.LinkedList;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {

		System.out.println(removeinvalidParenthese("()())()"));

	}

	public static LinkedList<String> removeinvalidParenthese(String str) {

		LinkedList<String> ret = new LinkedList<String>();
		LinkedList<String> temp = new LinkedList<String>();
		HashSet<String> set = new HashSet<String>();
		temp.add(str);
		while (!temp.isEmpty()) {
			for (String s : temp) {
				if (isValidParentheses(s)) {
					ret.add(s);
				}
			}
			if (!ret.isEmpty()) {
				return ret;
			}

			LinkedList<String> temp1 = new LinkedList<String>();
			for (String s : temp) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != '(' && s.charAt(i) != ')') {
						continue;
					}
					String t = s.substring(0, i) + s.substring(i + 1);
					if (set.contains(t)) {
						continue;
					} else {
						temp1.add(t);
						set.add(t);
					}
				}
			}
			temp = temp1;

		}
		return ret;

	}

	private static boolean isValidParentheses(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}
		return count == 0;
	}
}
