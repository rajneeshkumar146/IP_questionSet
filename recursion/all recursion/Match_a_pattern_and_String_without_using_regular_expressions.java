package BackTracking;

import java.util.HashMap;

public class Match_a_pattern_and_String_without_using_regular_expressions {

	public static void main(String[] args) {
		String st = "GeeksforGeeks";
		String pat = "gfg";

		HashMap<Character, String> map = new HashMap<>();
		System.out.println(pattern(st, pat, 0, 0, map));
	}

	private static boolean pattern(String st, String pat, int sidx, int patidx, HashMap<Character, String> map) {
		if (sidx == st.length() && patidx == pat.length()) {
			return true;
		}
		if (sidx == st.length() || patidx == pat.length()) {
			return false;
		}

		char ch = pat.charAt(patidx);
		if (map.containsKey(ch)) {
			String check = map.get(ch);
			String tobechecked = "";
			if (sidx + check.length() <= st.length()) {
				tobechecked = st.substring(sidx, sidx + check.length());
			}
			if (check.equals(tobechecked) == false) {
				return false;
			} else {
				return pattern(st, pat, sidx + check.length(), patidx + 1, map);
			}
		} else {
			for (int i = 1; i <= st.length() - sidx; i++) {
				String temp = st.substring(sidx, sidx + i);

				map.put(ch, temp);
				if (pattern(st, pat, sidx + i, patidx + 1, map)) {
					return true;
				}
				map.remove(ch);
			}
		}
		return false;
	}
}
