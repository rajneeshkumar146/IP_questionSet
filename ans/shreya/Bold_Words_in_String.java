package InternQuestAS1;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bold_Words_in_String {
	public static String boldWords(String[] words, String s) {
		boolean[] bold = new boolean[s.length() + 1];
		for (String w : words) {
			int start = s.indexOf(w, 0);
			while (start != -1) {
				Arrays.fill(bold, start, start + w.length(), true);
				start = s.indexOf(w, start + 1);//check next occurance of word
			}
		}
		StringBuilder r = new StringBuilder().append(bold[0] ? "<b>" : "");
		for (int i = 0; i < bold.length - 1; i++) {
			r.append(s.charAt(i));
			if (!bold[i] && bold[i + 1]) {
				r.append("<b>");
			}

			else if (bold[i] && !bold[i + 1]) {
				r.append("</b>");
			}
		}
		return r.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String[] words = { "ab", "bc" };
		String s = "aabcd";
		System.out.println(boldWords(words, s));

	}

}
