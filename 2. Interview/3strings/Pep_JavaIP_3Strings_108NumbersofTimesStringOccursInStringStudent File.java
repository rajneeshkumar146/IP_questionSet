--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a text string (string of larger length) and a pattern string
(string of smaller length).
2. You have to calculate number of times pattern string appears in the text
string, whether continuous or discontinuous.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_108NumbersofTimesStringOccursInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		int result = solve(str, pattern);
		System.out.println(result);
	}

	private static int solve(String str, String pattern) {
		//function to calculate number of times pattern string appears
		// in text string, whether continuous or discontinuous.

		//return the count
	}

}

/*
Test cases:

pepforpepepep
pep
---------------
27


geeksforgeeks
gks
----------------------
4


abacdssaaa
aba
------------------------
4


	Source: https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
 */
