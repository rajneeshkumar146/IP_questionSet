package InternshipQuestionAs1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Subsets {

	public static void main(String[] args) {
		String a[] = { "amazon", "apple", "facebook", "google", "leetcode" };

		String b[] = { "lo", "eo" };

		System.out.println(wordSubsets(a, b));

	}

	public static List<String> wordSubsets(String[] A, String[] B) {

		List<String> res = new ArrayList<>();
		int[] req = new int[26];
		int[] temp = new int[26];

		for (String b : B) {

			for (char c : b.toCharArray())
				temp[c - 'a']++;

			for (int i = 0; i < 26; i++)
				req[i] = Math.max(temp[i], req[i]);

			Arrays.fill(temp, 0);
		}
		// System.out.println(Arrays.toString(req));

		for (String a : A) {

			for (char c : a.toCharArray())
				temp[c - 'a']++;

			if (isValid(req, temp))
				res.add(a);

			Arrays.fill(temp, 0);
		}

		return res;

	}

	private static boolean isValid(int[] req, int[] che) {
		for (int i = 0; i < 26; i++)
			if (req[i] > che[i])
				return false;

		return true;
	}

}