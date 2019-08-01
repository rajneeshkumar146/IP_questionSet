package InternQuestAS1;

import java.util.Scanner;

public class Unique_Letter_String {
	public static int uniqueLetterString(String s) {
		int[] lastPosition = new int[26];
		int[] contribution = new int[26];
		int res = 0;

		
		for (int i = 0; i < s.length(); i++) {

			int curChar = s.charAt(i) - 'A';
			int totalNumOfSubstringsEndingHere = i + 1;
			contribution[curChar] = totalNumOfSubstringsEndingHere - lastPosition[curChar];

			int cur = 0;
			for (int j = 0; j < 26; j++) {
				cur += contribution[j];
			}

			res += cur;

			lastPosition[curChar] = i + 1;
		}
		return res;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(uniqueLetterString(s));

	}

}
