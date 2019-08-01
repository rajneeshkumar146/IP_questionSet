-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given two strings of lower alphabet characters.
2. You have to insert a character in the first string,
   such that length of LCS of both strings increases by one.
3. You have to print the total number of ways in which character can be inserted.
4. For simplicity assume all the character of the given strings are unique.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_81IncreaseLCSby1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();

		int count=0;
      	//code to print the number of ways by which LCS can be increased by one 
     System.out.println(count);
	}

}
/*
Test Cases:
abed abc
------------------------
3

abcefd abcde
------------------------
0

Source: https://www.geeksforgeeks.org/count-ways-increase-lcs-length-two-strings-one/
*/
