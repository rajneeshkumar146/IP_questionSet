package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_199LCSofTriplet {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		String s3 = scn.nextLine();
		
		System.out.println(lcs(s1, s2, s3));
	}
	
	private static int lcs(String s1, String s2, String s3){
		int[][][] strg = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
		
		for(int i = s1.length() - 1; i >= 0; i--){
			char ch1 = s1.charAt(i);
			
			for(int j = s2.length() - 1; j >= 0; j--){
				char ch2 = s2.charAt(j);
				
				for(int k = s3.length() - 1; k >= 0; k--){
					char ch3 = s3.charAt(k);
					
					if(ch1 == ch2 && ch2 == ch3){
						strg[i][j][k] = 1 + strg[i + 1][j + 1][k + 1];
					} else {
						strg[i][j][k] = Math.max(strg[i + 1][j][k], Math.max(strg[i][j + 1][k], strg[i][j][k + 1]));
					}
				}
			}
		}
		
		return strg[0][0][0];
	}

}

// https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
/* Test case 1 
abcd1e2
bc12ea
bd1ea
3
*/

/* Test case 2 
geeks
geeksfor
geeeksforgeeks
5
*/