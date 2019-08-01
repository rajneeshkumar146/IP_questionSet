package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_90LexicographicFirstPalindrome {
/* What : lexicographic first palindromic string
 *
 * How : Build freq map of string check if palindrome can be made by using proerties of palindromic strings
 *      If possible to build, start putting chars in sorted order from both ends(palindrome)    
 *
 * Why :Palindromes are special type of strings, with following properties based on length.
 *      Even length : All chars must have even frequency. Example: aaaa,len=4-->valid. aabc, len=4-->invalid       
 *      Odd length: Only one char must have odd frequency. Put this one char at middle
*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		boolean result = ispossible(str);
		/* Guarantees that state of string is such that it can be made palindrome
		 * Either all chars with even frequency.
		 * Or only one char with odd frequency
		*/
		if (result == true) {
			int[] fmap = new int[26];
			for (int i = 0; i < str.length(); i++) {
				fmap[str.charAt(i) - 'a']++;
			}

			
			char ch = '\0';
			/*Extract the only char with odd frequency*/
			for (int i = 0; i < 26; i++) {
				if (fmap[i] % 2 != 0) {
					ch = (char) (i + 'a');
					fmap[i]--;
				}
			}
			
			char[] str_array = str.toCharArray();
			int left = 0;
			int right = str.length() - 1;
			
			for (int i = 0; i < 26; i++) {
				if (fmap[i] > 0) {
					/*Put all even frequency chars from both ends*/
					int k = fmap[i] / 2;
					int j = 0;
					/*current even frequecy char is not exhausted, keep putting it*/
					while (j < k) {
						
						str_array[left] = (char) (i + 'a');
						str_array[right] = (char) (i + 'a');
						left++;
						right--;
						j++;
					}

				}
			}
			/*Odd length string, put char in middle*/
			if (left == right) {
				str_array[left] = ch;
			}

			for (char ch1 : str_array) {
				System.out.print(ch1);
			}
		} else {
			System.out.println("Not Possible");
		}

	}

	private static boolean ispossible(String str) {

		int[] fmap = new int[26];
		for (int i = 0; i < str.length(); i++) {
			fmap[str.charAt(i) - 'a']++;
		}

		/*Even length all  characters must have even frequency*/
		if (str.length() % 2 == 0) {
			for (int i = 0; i < 26; i++) {
				if (fmap[i] % 2 != 0) {
					return false;
				}
			}
		} else {
			/*Odd length only one character must have odd frequency*/
			boolean flag = false;
			for (int i = 0; i < 26; i++) {
				if (fmap[i] % 2 != 0 && flag == true) {
					return false;
				} else if (fmap[i] % 2 != 0 && flag == false) {
					flag = true;
				}
			}
		}
		return true;
	}

}

/*
Test cases:
	malayalam
	-----------------
	aalmymlaa
	
	
	apple
	--------------------
	Not Possible
	
	
	nitin
	----------------------
	intni
	
	Source: https://www.geeksforgeeks.org/lexicographically-first-palindromic-string/
	*/
