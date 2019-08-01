package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_96PrintDistinctCharacters {
/* What : Print all distinct chars in order, i.e remove repeating substrings
 * How :  Make frequency map, of chars. Iterate over string. Print only when count is one  
 * Why : To preserve order, iterate over string.
*/
	public static void printDistinct(String str) {
		int n = str.length();

		// count array will store the count of all characters
	
		int[] count = new int[26];

		for (int i = 0; i < n; i++) {
			int charIdx = (int) (str.charAt(i) - 'a');
			++count[charIdx];
		}
		
		/*Iteration over string preserves order of chars*/
		for (int i = 0; i < n; i++) {
			
			char currChar = str.charAt(i);
			
			int freqOfChar = count[(currChar - 'a')];
			if(freqOfChar == 1) {
				System.out.print(x);
			}
			
		}
		
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		printDistinct(str);
	}

}

/*
 geeksforgeeks
 --------------------------
for

pepcoding
-------------
ecoding

aabbcdesggfhjjjdkhdbb
-----------------------
cesfk

Source: https://www.geeksforgeeks.org/print-all-distinct-characters-of-a-string-in-order-3-methods/
 */
