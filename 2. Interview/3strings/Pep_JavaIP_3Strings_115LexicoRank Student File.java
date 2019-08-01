--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string.
2. You have to print the rank of the string among all its permutations sorted
lexicographically.
3. For simplicity assume that all the characeters of the string are unique.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_115LexicoRank {
	    // A utility function to find factorial of n
	    static int fact(int n)
	    {

	    }

	    // A utility function to count smaller
	    // characters on right of arr[low]
	    static int findSmallerInRight(String str, int low,
	                                            int high)
	    {

	    }

	    // A function to find rank of a string in
	    // all permutations of characters
	    static int findRank (String str)
	    {

	    }

	    // Driver program to test above function
	    public static void main(String[] args)
	    {
	    	Scanner scn=new Scanner(System.in);
	        String str = scn.next();
	        System.out.println (findRank(str));
	    }



}

/*
 * Test cases:
abc
 ---------------
 1

 abcd
 ---------------
 1


 xabcdgh
 ---------------
 4321


  Source:
 https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/


 */
