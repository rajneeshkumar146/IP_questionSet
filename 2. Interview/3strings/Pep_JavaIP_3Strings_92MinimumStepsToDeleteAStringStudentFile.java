-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a string of integers.
2. Condition on deletion in 1 step - 
   a. You can delete the substring which is a palindrome.
   b. After deleting a substring, remaining parts are concatenated.
3. You have to print the minimum number of steps required to delete all characters of the given string.  
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_92MinimumStepsToDeleteAString {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		
		int[][] mat=new int[str.length()][str.length()];
		
		 
		
		System.out.println(mat[0][str.length()-1]);
	}

}
/*
Test cases:
	2553432
	-----------------
	2
	
	
	24334445
	--------------------
	4
	
	
	00000000000
	----------------------
	1
	
	Source: https://www.geeksforgeeks.org/minimum-steps-to-delete-a-string-after-repeated-deletion-of-palindrome-substrings/
	*/

