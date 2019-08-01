package BackTracking;

import java.util.HashMap;

public class Flip_Game_2 {

	public static void main(String[] args) {
		String s = "++++";
		System.out.println(Flip(s));
	}

	private static boolean Flip(String s) {
		HashMap<String, Boolean> map = new HashMap<>();
		return dfs(s, map);
	}

	private static boolean dfs(String st, HashMap<String, Boolean> map) {
		if (map.containsKey(st)) {
			return map.get(st);
		}
		for (int i = 0; i < st.length() - 1; i++) {
			if (st.substring(i, i + 2).equals("++")) {
				String s = st.substring(0, i) + "--" + st.substring(i + 2);
				if (dfs(s, map) == false) {
					map.put(st, true);
					return true;
				}
			}
		}
		map.put(st, false);
		return false;
	}
}
