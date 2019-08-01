-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a string of lower alphabet characters.
2. You have to print the length of largest substring which is not palindrome.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_91LongestNonPalindromicSubString {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();


		//code to find the length of largest substring which is not a palindrome


		boolean result=ispalindrome(str);

    //output based on result of ispalindrome

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
