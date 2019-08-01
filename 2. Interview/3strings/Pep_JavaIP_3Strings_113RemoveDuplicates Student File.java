--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string.
2. You have to recursively remove adjacent duplicate characters from string.
3. You have to print the output string.
4. The output string should not have any adjacent duplicates.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_113RemoveDuplicates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		removeduplicates(str, 0, 0);
	}

	private static void removeduplicates(String str, int vidx, int diff) {
		//function to remove adjacent duplicates.
	}

}

/*
 * Test cases:

  azxxzy
  --------------
  ay

  geeksforgeeg
  --------------------
  gksfor

  caaabbbaacdddd
  -------------------

  acaaabbbacdddd
  ---------------------
  acac

  Source:
  https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/


 */
