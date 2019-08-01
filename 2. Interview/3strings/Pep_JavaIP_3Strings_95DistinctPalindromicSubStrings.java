package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_95DistinctPalindromicSubStrings {
/* What : All distinct palindromic strings
 * How : Find all palindromic substrings, using 2-d gap strategy, iterate over filled matrix
         put substring(i,j+1) in HashMap if dp[i][j] is true.   
 * 
 *   Why : HashMap only stores distinct value, so only distinct palindromes are stored.  
*/
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		palin_substrings(new boolean[str.length()][str.length()], str);
	}

	public static void palin_substrings(boolean[][] arr, String str) {
		HashMap<String,Boolean> set=new HashMap<>();
		for (int gap = 0; gap < str.length(); gap++) {
			int i = 0;
			int j = i + gap;
			while (j < str.length()) {
				if (gap == 0) {
					arr[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						arr[i][j] = true;
					}
				} else {
					if (str.charAt(i) == str.charAt(j) && arr[i + 1][j - 1]) {
						arr[i][j] = true;
					}
				}

				i++;
				j++;
			}
		}
		
		for (int gap = 0; gap < str.length(); gap++) {
			int i = 0;
			int j = i + gap;
			while (j < str.length()) {
				if(arr[i][j]==true) {
					set.put(str.substring(i,j+1),true);
				}
				i++;
				j++;
			}
		}
		
		/*So output matches */
		ArrayList<String> al=new ArrayList(set.keySet());
		Collections.sort(al);
		for(String st: al) {
			System.out.println(st);
		}
		
		
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
