--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string(sequence of uppercase characters).
2. You have to print "true", if there is any subsequence of length 2 or more that
repeats itself such that the two subsequence don’t have same character at same
position in the given string.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_127RepeatedSubsequenceOfLength2OrMore {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		if (getprob(str)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

//function to check if the given string contains repeated subsequences of length
//2 or more
	public static boolean getprob(String str) {

		}

// utility function to find that given string is palindrome or not
	public static boolean Ispalindrome(String str) {

	}


}

/*
Test cases:
AABBC
----------------------
true


ABCDACB
-----------------
true

AAB
------------------------
false


	Source: https://www.geeksforgeeks.org/repeated-subsequence-length-2/
 */
