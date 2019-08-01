--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string consisting of digits 0-9.
2. You are given an integer n.
3. You have to print the count of subsequences of given string which are
divisible by n.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_107CountSubsequencesDivisibleByN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner scn=new Scanner(System.in);
	       String str=scn.next();

		   int n=scn.nextInt();
		   //returning the total no. of subsequences in a string divisible by n.

	       System.out.println( getprob( str, n));


	}

	public static int getprob(String str1, int n) {
		//function to calculate number of subsequences of string str1, which are
		//divisible by n
		//return the count of subsequences
	}

}

/*
Test cases:
	1234
	4
	-------------
	4

	330
	6
	----------------------
	4


	676
	6
	----------------------
	3

	Source: https://www.geeksforgeeks.org/number-subsequences-string-divisible-n/
	*/
