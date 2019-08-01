package interview.strings;

import java.util.Scanner;

public class Pep_JavaIP_3strings_86LongestPalindromicSubstring {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		solve(str);
	}

	private static void solve(String str) {
		String oans = null;

		// odd length
		for (int axis = 0; axis < str.length(); axis++) {
			int orbit = 0;
			while (axis - orbit >= 0 && axis + orbit < str.length()) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					String ans = str.substring(axis - orbit, axis + orbit + 1);
					oans = oans == null? ans: ans.length() > oans.length()? ans: oans;
				} else {
					break;
				}
				orbit++;
			}
		}

		// even length
		for (int axis = 1; axis < str.length(); axis++) {
			double orbit = 0.5;
			while (axis - orbit >= 0 && axis + orbit < str.length()) {
				if (str.charAt((int)(axis - orbit)) == str.charAt((int)(axis + orbit))) {
					String ans = str.substring((int)(axis - orbit), (int)(axis + orbit + 1));
					oans = oans == null? ans: ans.length() > oans.length()? ans: oans;
				} else {
					break;
				}
				orbit++;
			}
		}
		
		System.out.println(oans);
	}

}
