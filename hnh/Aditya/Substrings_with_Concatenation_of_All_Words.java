package HnH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Substrings_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		String st = "a";
		String[] words = { "a" };
		System.out.println(findSubstring(st, words));
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		int len = words[0].length();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		for (int i = 0; i <= s.length() - len; i++) {
			String sub = s.substring(i, i + len);
			if (map.containsKey(sub)) {
				HashMap<String, Integer> tempmap = new HashMap<>(map);
				tempmap.put(sub, tempmap.get(sub) - 1);
				if (tempmap.get(sub) == 0) {
					tempmap.remove(sub);
				}
				if (tempmap.size() == 0) {
					ans.add(i);
					continue;
				}
				int j = i + len;
				boolean flag = false;
				while (j <= s.length() - len) {
					String sub1 = s.substring(j, j + len);
					if (tempmap.containsKey(sub1)) {
						tempmap.put(sub1, tempmap.get(sub1) - 1);
						if (tempmap.get(sub1) == 0) {
							tempmap.remove(sub1);
						}
						j = j + len;
						if (tempmap.size() == 0) {
							flag = true;
							break;
						}
					} else {
						break;
					}
				}
				if (flag == true) {
					ans.add(i);
				}
			}
		}
		return ans;
	}
}
