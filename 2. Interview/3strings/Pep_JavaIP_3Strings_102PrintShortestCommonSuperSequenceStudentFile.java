-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given two strings, str1 and str2.
2. You have to print the shortest string that has both str1 and str2 as its subsequences.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_102PrintShortestCommonSuperSequence {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String one=scn.next();
		String two=scn.next();
		supersequence(one, two);
	}

	private static void supersequence(String one, String two) {
		String[][] superseq=new String[one.length()+1][two.length()+1];
		int j=two.length();
		for(int i=0; i<one.length(); i++) {
			superseq[i][j]=one.substring(i);
		}
		int i=one.length();
		for(j=0; j<two.length(); j++) {
			superseq[i][j]=two.substring(j);
		}

	//code starts here


	//code ends here

		System.out.println(superseq[0][0]);
	}

}

/*
Test cases:

pepforpepepep
pep
---------------
pepforpepepep


geeksforgeeks
hello
----------------------
geheksfllorgeeks


abacdssaaa
xyzsabaa
------------------------
xyzsabacdssaaa


	Source: https://www.geeksforgeeks.org/print-shortest-common-supersequence/
 */
