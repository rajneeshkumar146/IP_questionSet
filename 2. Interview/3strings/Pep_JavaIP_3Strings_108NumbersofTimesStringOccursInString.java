package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_108NumbersofTimesStringOccursInString {

	public static void main(String[] args) {  

		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		int result = solve(str, pattern);
		System.out.println(result);
	}

	private static int solve(String str, String pattern) {
		int[] pattern_aux = new int[pattern.length()];
	// Each element in array pattern_aux  represents the  number of 
	// strings formed from the last upto that index.
	
	//starting of loop with last index.
		for (int i = str.length() - 1; i >= 0; i--) {
		//initializing the loop for pattern length for each i in String str.
			for (int j = 0; j < pattern.length(); j++) {
				if (str.charAt(i) == pattern.charAt(j)) {
		//update the array only when the characters in str and pattern becomes equal.
					if (j == pattern.length() - 1) {
	
						pattern_aux[pattern.length() - 1] += 1;
					} else if (str.charAt(i) == pattern.charAt(j)) {
	//updating the value at j 
	//suppose  we have to form "abc" string and there are 10 "bc" strings and now character 'a' comes 
	// then it should be appended to all "bc" strings to form 10 "abc" strings.
						pattern_aux[j] += pattern_aux[j + 1];
					}

				}
			}
		}
	//return the last index count which means the complete pattern is formed.

		return pattern_aux[0];
	}

}

/*
Test cases:

pepforpepepep
pep
---------------
27


geeksforgeeks
gks
----------------------
4


abacdssaaa
aba
------------------------
4
	
	
	Source: https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
 */
