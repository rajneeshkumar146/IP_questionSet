package may30;

import java.util.ArrayList;

public class find_all_anagrams {

	public static void main(String[] args) {
		findAnagrams("cbaebabacd", "abc");
	}

	public static ArrayList<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> arr = new ArrayList<>();

		int[] charhash = new int[26];

		for (char c : p.toCharArray()) {
			charhash[c - 'a']++;
		}

		if (s.length() < p.length()) {
			return arr;
		}

		int[] windowcharhash = new int[26];

		int start = 0 - p.length();
		int end = -1;
		int matchedcount = 0;

		while (true) {

			if (matchedcount == p.length()) {
				arr.add(start);
			}

			end++;
			if( end>=s.length()){
				break;
			}
			
			if (end < 0 ) {

			} else {
				if (windowcharhash[s.charAt(end) - 'a'] < charhash[s.charAt(end) - 'a']) {
					matchedcount++;
				}
				windowcharhash[s.charAt(end) - 'a']++;

			}

			if (start < 0) {

			} else {

				if (windowcharhash[s.charAt(start) - 'a'] == charhash[s.charAt(start) - 'a']) {
					matchedcount--;
				}
				windowcharhash[s.charAt(start) - 'a']--;

			}

			start++;

		}

		return arr;

	}
}
