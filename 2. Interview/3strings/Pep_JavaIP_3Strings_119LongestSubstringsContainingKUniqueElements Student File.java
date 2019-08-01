--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string and an integer k.
2. You have to print longest possible substring that has exactly k unique
characters.
3. You have to print "Not possible", if number of unique characters in the
string are less than k.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_119LongestSubstringsContainingKUniqueElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k=scn.nextInt();
		printsubstring(str, k);
	}

	private static void printsubstring(String str, int k) {
		//function to print longest possible substring that has exactly k unique
		//characters.
	}

//utility function to handle case when number of unique characters in the string
// are less than k
	private static boolean isValid(int[] fmap, int k) {

	}

}

/*
 * Test cases:
aabbcc
1
 ---------------
 aa

 aabbccd
2
 ---------------
 aabb


 xaabbccdghiiiii
3
 ---------------
 ghiiiii


  Source:
 https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/


 */
