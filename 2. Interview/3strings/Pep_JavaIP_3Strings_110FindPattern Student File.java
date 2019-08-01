--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string which contains patterns of the form 1(0+)1 where (0+)
represents any non-empty consecutive sequence of 0’s.
2. You have to return the count of all such patterns.
3. Patterns are allowed to overlap.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_110FindPattern {

	 static int patternCount(String str)
	    {
	        //function to calculate the count of patterns of the
					//form 1(0...)1

	        //return the count as result
	    }

	    public static void main (String[] args)
	    {
	        Scanner scn=new Scanner(System.in);

	        String str = scn.next();

	        System.out.println(patternCount(str));

	    }

}

/*
Test cases:
	1101001
	---------------
	2


	10001abc101
	-----------------
	2


	110001001101
	--------------
	3


	Source: https://www.geeksforgeeks.org/find-patterns-101-given-string/
	*/
