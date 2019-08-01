package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_81IncreaseLCSby1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();

		int[][] prefix = new int[s2.length() + 1][s1.length() + 1];

		for (int i = 0; i < prefix.length; i++) {
			for (int j = 0; j < prefix[0].length; j++) {
				if (i == 0 || j == 0) {
					prefix[i][j] = 0;
				} else if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
					prefix[i][j] = prefix[i - 1][j - 1] + 1;
				} else {
					prefix[i][j] = Math.max(prefix[i - 1][j], prefix[i][j - 1]);
				}
			}
		}
		int lcs = prefix[s2.length()][s1.length()];

//		for (int i = 0; i < prefix.length; i++) {
//			for (int j = 0; j < prefix[0].length; j++) {
//				System.out.print(prefix[i][j] + " ");
//			}
//			System.out.println();
//		}

		int[][] suffix = new int[s2.length() + 1][s1.length() + 1];

		for (int i = s2.length(); i >= 0; i--) {
			for (int j = s1.length(); j >= 0; j--) {
				if (i == s2.length() || j == s1.length()) {
					suffix[i][j] = 0;
				} else if (s2.charAt(i) == s1.charAt(j)) {
					suffix[i][j] = suffix[i + 1][j + 1] + 1;
				} else {
					suffix[i][j] = Math.max(suffix[i + 1][j], suffix[i][j + 1]);
				}
			}
		}

		// for (int i = 0; i < prefix.length; i++) {
		// for (int j = 0; j < prefix[0].length; j++) {
		// System.out.print(suffix[i][j] + " ");
		// }
		// System.out.println();
		// }

		// find uncommon elements in str2 with respect to str1
		// frequency map of str1
		int[] fmap = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			fmap[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			fmap[s2.charAt(i) - 'a']--;
		}

		ArrayList<Character> al = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			if (fmap[i] < 0) {
				// these are extra elements in s2
				al.add((char) ('a' + i));
			}
		}

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < al.size(); i++) {
			for (int i1 = 0; i1 < s2.length(); i1++) {
				if (s2.charAt(i1) == al.get(i)) {
					map.put(s2.charAt(i1), i1);
				}
			}
		}


		// try for each character in the arraylist
		int count = 0;
		for (int i = 0; i < al.size(); i++) {
			int index = map.get(al.get(i));
			for (int i1 = 0; i1 <= s1.length(); i1++) {
				if (prefix[index][i1] + suffix[index+1][i1] == lcs) {
					count++;
				}
			}

		}
		
		System.out.println(count);

	}

}
