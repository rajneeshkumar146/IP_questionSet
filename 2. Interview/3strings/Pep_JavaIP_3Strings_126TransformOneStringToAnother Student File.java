--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given 2 strings : String1 and String2.
2. You have to convert String1 into String2.
3. The only operation allowed is to put any character from String1 and insert it
at front.
4. You have to print the count of minimum number of operations possible to
convert String1 into String2.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_126TransformOneStringToAnother {

	public static void main(String[] args) {
		//Please input string in the the form of lowercase letters.

		Scanner scn = new Scanner(System.in);
		String fstr = scn.next();
		String sstr = scn.next();
		System.out.println(getprob(fstr, sstr));
	}

	public static int getprob(String fstr, String sstr) {
		//function to print the count of minimum number of operations possible to
		//convert String1 into String2.
	}

}

/*
Test cases:
	eabcd
	eacbd
	------------------------
	3

	abd
	bad
	-----------------
	1


	geek
	geek
	--------------------
	0

	Source: https://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/
 */
