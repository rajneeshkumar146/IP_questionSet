--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string and an integer n which represents number of rows.
2. You have to print the string formed by concatenating n rows when input string
is written in row-wise Zig-Zag fashion.
3. For example: Input: str = "GEEKSFORGEEKS"
       n = 3
Output: GSGSEKFREKEOE
Explanation: Let us write input string in Zig-Zag fashion
             in 3 rows.
G       S       G       S
  E   K   F   R   E   K
    E       O       E
Now concatenate the two rows and ignore spaces
in every row. We get "GSGSEKFREKEOE"
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_124PrintZigZagFashion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int n = scn.nextInt();
		getprob(str, n);
	}

	private static void getprob(String str1, int n) {
		//function to print the string in row wise form
	}

}
/*
Test cases:
	abcdefgh
	2
	------------------------
	acegbdfh

	pecoding
	4
	------------------------
	pneigcdo


	geeksforgeeks
	3
	------------------------
	gsgsekfrekeoe



	Source: https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
 */
