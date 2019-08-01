package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_101PrintAllLongestCommonSubSequencesinLexicoOrder {
/* What :Given a string find its lcs, print all possible lcs.
 * How : Build lcs table , iterate over it.Start matching character by character from str1 to str2
 *			 if character matches, then rest of strings must form lcs of length lcslen-currlen
 * Why : We need to check only when both chars are equal and length of lcs from both
 *(str1,str2)-->(i+1,j+1)  left is equal to lcslen - currlen.
 *
*/
	static int[][] dp = null;
	/*Length of longest common subsequences*/
	static int lcslen;
	static ArrayList<String> arr = new ArrayList();

/*Build lcs table*/
	public static int lcs(String s1, String s2, int len1, int len2, int i, int j) {

		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int ret;
		if (i == len1 || j == len2)
			return ret = 0;

		 ret = dp[i][j];

		 /*If lcs found then return value*/
		if (ret != -1)
			return ret;

		ret = 0;

		if (str1[i] == str2[j])
			ret = 1 + lcs(s1, s2, len1, len2, i + 1, j + 1);
		else
			ret = Math.max(lcs(s1, s2, len1, len2, i + 1, j), lcs(s1, s2, len1, len2, i, j + 1));
		return ret;
	}

	public static void printAll(String s1, String s2, int len1, int len2, char[] data, int indx1, int indx2,
			int currlcs) {

		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		/*adds all lcs's to ArrayList*/
		if (currlcs == lcslen) {
			data[currlcs] = '\0';
			String s=new String(data);
			arr.add(s);

			return;
		}

		if (indx1 == len1 || indx2 == len2)
			return;

		/*To print in sorted order*/
		for (char ch = 'a'; ch <= 'z'; ch++) {
			// done is a flag to tell that we have printed all the
			// subsequences corresponding to current character
			boolean done = false;

			for (int i = indx1; i < len1; i++) {

				if (ch == str1[i]) {
					for (int j = indx2; j < len2; j++) {

						// if ch is present in both of them and
            // remaining length is equal to remaining
            // lcs length then add ch in sub-sequenece
						if (ch == str2[j] && lcs(s1, s2, len1, len2, i, j) == lcslen - currlcs) {
							data[currlcs] = ch;
							printAll(s1, s2, len1, len2, data, i + 1, j + 1, currlcs + 1);
							done = true;
							break;
						}
					}
				}
				// If we found LCS beginning with current character.
				if (done)
					break;
			}
		}
	}

	public static void prinlAllLCSSorted(String str1, String str2) {
		int len1 = str1.length(), len2 = str2.length();

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				dp[i][j] = -1;
			}
		}

		lcslen = lcs(str1, str2, len1, len2, 0, 0);
		int max = Math.max(len1, len2);

		char data[] = new char[max];
		printAll(str1, str2, len1, len2, data, 0, 0, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String str2 = scn.next();
		dp = new int[str.length()][str2.length()];

		prinlAllLCSSorted(str, str2);
		for(String str1: arr) {
			System.out.println(str1);
		}
	}


}

/*
Test cases:
abcd
abdc
------------------------
abc
abd



abcabcaa
acbacba
----------------------
ababa
abaca
abcba
acaba
acaca
acbaa
acbca



abcabcaa
acbacbaa
-----------------
ababaa
abacaa
abcbaa
acabaa
acacaa
acbcaa




	Source: https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
 */
