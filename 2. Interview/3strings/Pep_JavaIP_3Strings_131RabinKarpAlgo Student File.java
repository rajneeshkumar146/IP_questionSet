--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given 2 strings: text and pattern.
2. You have to print the index where the given pattern is found repeated in text
string.
3. You have to print according to output format. Please refer to sample test cases
for details. 
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_131RabinKarpAlgo {

	    static void search(String pat, String txt, int q)
	    {
	        //function to search the given pattern in the given text string
	    }

	    /* Driver program to test above function */
	    public static void main(String[] args)
	    {
	      Scanner scn=new Scanner(System.in);
	    	String txt = scn.nextLine();
	      String pat = scn.nextLine();
	      int q = 101; // A prime number
	      search(pat, txt, q);
	    }
}

/*
Test cases:
	This is test case
	test
	-----------------
	Pattern found at index 8


	GEEKS FOR GEEKS
	GEEKS
	--------------------
	Pattern found at index 0
	Pattern found at index 10


	PEPCODING-PursuitofExcellence
	Excel
	--------------------
	Pattern found at index 19


	Source: https://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
	*/
