package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_102PrintShortestCommonSuperSequence {
/* What :Given str1 and str2, find the shortest possible str3 , such that str1 and str2 are subsequences of it
 * How : Build a string matrix, start from end fill supersequence of blank with both str1 and str2 in last row,col
*  where each (i,j)--> represents supersequence of str1(i, str1.length) and str2(j,str2.length)
* Why : Subproblems of decreasing length, optimal substructure--> supersequence of smaller strings
 *
*/
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String one=scn.next();
		String two=scn.next();
		supersequence(one, two);
	}

	private static void supersequence(String one, String two) {
		String[][] superseq=new String[one.length()+1][two.length()+1];

		/*Put supersequence of ""(blank) and substring of str1 from i to len
		* in last column.
		 */
		int j=two.length();
		for(int i=0; i<one.length(); i++) {
			superseq[i][j]=one.substring(i);
		}
		/*Put supersequence of ""(blank) and substring of str2 from i to len
		*	in last row
		*/
		int i=one.length();
		for(j=0; j<two.length(); j++) {
			superseq[i][j]=two.substring(j);
		}

		for(i=one.length()-1; i>=0; i--) {
			for(j=two.length()-1; j>=0; j--) {
				/*Character doesn't match then take shortest supersequence ,
				*exclude one char from both strings, check lengths (i,j)--> min lengths
				*/
				if(one.charAt(i)!=two.charAt(j)) {
					String f1=one.charAt(i)+superseq[i+1][j];
					String f2=two.charAt(j)+superseq[i][j+1];
					superseq[i][j]=(f1.length()>f2.length())?f2:f1;
				}else {
					superseq[i][j]=one.charAt(i)+superseq[i+1][j+1];
				}
			}
		}

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
