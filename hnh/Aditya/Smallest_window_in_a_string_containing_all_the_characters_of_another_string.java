package may29;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Smallest_window_in_a_string_containing_all_the_characters_of_another_string {

	public static void main(String[] args) {
		System.out.println(func("timetopractice", "toc"));

	}

	public static String func(String s, String t) {
		String ques = s;
		String req = t;

		int leftindex = 0;
		int rightindex = 0;

		int[] charinreq = new int[26];
		int[] charinans = new int[26];

		for (char ch : req.toCharArray()) {
			charinreq[ch - 'a']++;
		}

		int charmatched = 0;
		LinkedList<Character> ans = new LinkedList<>();
		int currlen = 0;

		LinkedList<Character> actualmin = new LinkedList<>();
		int minlen = Integer.MAX_VALUE;

		while (true) {
			char toput = ques.charAt(rightindex);

			if (charinreq[toput - 'a'] > 0) {
				if (charinans[toput - 'a'] < charinreq[toput - 'a'])
					charmatched++;
				charinans[toput - 'a']++;
			}

			ans.addLast(ques.charAt(rightindex));
			currlen++;

			if (charmatched == req.length()) {
				while (charinreq[ques.charAt(leftindex) - 'a'] == 0 // the
																	// character
																	// present
																	// is
																	// useless
																	// in answer
						|| charinans[ques.charAt(leftindex) - 'a'] > charinreq[ques.charAt(leftindex) - 'a']) { // removing
																												// the
																												// character
																												// doesn't
																												// destroys
																												// the
																												// sequence

					charinans[ques.charAt(leftindex) - 'a']--;
					// if (charinans[ques.charAt(leftindex) - 'a'] == 0)
					// charmatched--;

					leftindex++;
					ans.removeFirst();
					currlen--;

				}

				if (currlen < minlen) {
					actualmin = new LinkedList<>(ans);
					minlen = currlen;
				}

			}

			rightindex++;

			if (rightindex >= ques.length()) {
				break;
			}
		}

		if (actualmin.size() == 0) {
			return "-1";
		}

		String finalans = actualmin.toString();

		return finalans;

	}

}
