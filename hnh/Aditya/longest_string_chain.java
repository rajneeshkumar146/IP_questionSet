package june1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class longest_string_chain {
	public static int longestStrChain(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int res = 0;

		Arrays.sort(words, new Comparator<String>() { // sort words based on
														// size
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		});

		HashMap<String, Integer> map = new HashMap<>();

		for (String word : words) {
			if (map.containsKey(word)) // word already present ,skip,not
										// included twice in ans
				continue;

			map.put(word, 1);
			for (int i = 0; i < word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				sb.deleteCharAt(i); // generating all possible combos of string

				String next = sb.toString();

				if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
					map.put(word, map.get(next) + 1);
				}
			}

			if (map.get(word) > res)
				res = map.get(word);		// get ans with max predecessors
			
			
		}

		return res;
	}
}
