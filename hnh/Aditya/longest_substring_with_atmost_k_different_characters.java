package may31;

import java.util.HashMap;
import java.util.LinkedList;

public class longest_substring_with_atmost_k_different_characters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		String ques = s;

		if (s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> charinans = new HashMap<>();

		int leftindex = 0;
		int rightindex = 0;

		int charunique = 0;
		LinkedList<Character> ans = new LinkedList<>();
		int currlen = 0;

		LinkedList<Character> actualmax = new LinkedList<>();
		int maxlen = Integer.MIN_VALUE;

		while (true) {
			char toput = ques.charAt(rightindex);

			if (!charinans.containsKey(toput))
				charunique++;
			charinans.put(toput, charinans.getOrDefault(toput, 0) + 1);

			ans.addLast(ques.charAt(rightindex));
			currlen++;

			if (charunique == k + 1) {
				while (charunique != k) { // removing

					charinans.put(ques.charAt(leftindex), charinans.get(ques.charAt(leftindex)) - 1);

					if (charinans.get(ques.charAt(leftindex)) == 0) {
						charinans.remove(ques.charAt(leftindex));
						charunique--;
					}

					leftindex++;
					ans.removeFirst();
					currlen--;
				}

			}

			if (charunique <= k && currlen > maxlen) {
				actualmax = new LinkedList<>(ans);
				maxlen = currlen;
			}
			rightindex++;

			if (rightindex >= ques.length()) {
				break;
			}
			
		}

		if (actualmax.size() == 0) {
			return 0;
		}

		return maxlen;

	}
}
