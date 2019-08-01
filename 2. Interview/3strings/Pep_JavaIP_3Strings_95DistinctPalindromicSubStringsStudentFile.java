-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a string of lower alphabet characters.
2. You have to print all distinct palindromic sub-strings of it, in sorted order.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_95DistinctPalindromicSubStrings {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		palin_substrings(new boolean[str.length()][str.length()], str);
	}

	public static void palin_substrings(boolean[][] arr, String str) {
		
		
	}
}



/*
Test cases:
aaba
----------
a
aa
aba
b

aaababa
-----------------
a
aa
aaa
aba
ababa
b
bab


	abbaabbaaa
	------------------------
a
aa
aaa
aabbaa
abba
abbaabba
b
baab
bb
bbaabb
	
	
	
	Source: https://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 */
