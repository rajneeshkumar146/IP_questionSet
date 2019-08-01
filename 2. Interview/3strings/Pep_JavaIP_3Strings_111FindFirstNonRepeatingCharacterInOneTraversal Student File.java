--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string.
2. You have to print first non repeating character of the string.
3. You have to find the first non repeating character in single traversal of string.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_111FindFirstNonRepeatingCharacterInOneTraversal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		System.out.println(getprob(str));

	}

	public static char getprob(String str) {
		//function to print the first non-repeating character of the given string
		//return the character as result.
	}

}

/*
Test cases:
	pepcoding
	-------------
	e

	geeksforgeeeks
	----------------------
	f


	worldisallaboutmoney
	----------------------
	w

	Source: https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
	*/
