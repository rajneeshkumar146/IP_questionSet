package Strings;

import java.util.Scanner;
/*This code is WRONG*/
public class Pep_JavaIP_3Strings_92MinimumStepsToDeleteAString {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		
		int[][] mat=new int[str.length()][str.length()];
		
		for(int gap=0; gap<str.length(); gap++) {
			int i=0;
			int j=gap+i;
			while(j<str.length()) {
				if(gap==0) {
					mat[i][j]=1;
				}else if(gap==1) {
					mat[i][j]=(str.charAt(i)==str.charAt(j))?1:2;
				}else {
					if(str.charAt(i)==str.charAt(j)) {
						mat[i][j]=mat[i+1][j-1];
					}else {
						for(int k=i;k<j;k++){
							if(mat[i][j]==0) {
								mat[i][j]=mat[i][k]+mat[k+1][j];
							}else
								mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k+1][j]);
			            }
					}
				}
				i++;
				j++;
			}
		}
		
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

