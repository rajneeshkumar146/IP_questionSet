package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_91LongestNonPalindromicSubString {
/* What : length of largest Non-palindromic string
 * How : Trivial case-> all chars same, therefore can not form non-palindromic string
 *        If string non-palindromic-> length of string
 *        If palindromic-> len-1    
 * Why : Example : aabaa, len = 5, is palindromic so longest non-palindromic is aaba, len = 4
                   navdeep,len = 7, non-palindromic, so ans = 7.
*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		char ch = str.charAt(0);

		boolean charDistinct = false;

		//check if all the characters are same.
		for(int i = 1; i < str.length(); i++) {
			if(ch != str.charAt(i)) {
				charDistinct = true;
				break;
			}
		}

		//all characters are same
		if(charDistinct == false) {
			System.out.println("0");
			return;
		}

		boolean result = ispalindrome(str);

		if(result == true) {
			System.out.println(str.length()-1);
		}else {
			System.out.println(str.length());
		}

	}

	private static boolean ispalindrome(String str) {
		int left=0;
		int right=str.length()-1;
		while(left<=right) {
			if(str.charAt(left)!=str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}

/*
Test cases:
	nitin
	-----------------
	4


	apple
	--------------------
	5


	aaaaaaaaaaa
	----------------------
	0

	Source: https://www.geeksforgeeks.org/longest-non-palindromic-substring/
	*/
