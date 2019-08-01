package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_130PrintAllSentencesPossible {
	
	public static void printUtil(String arr[][], int m, int n, String output[]) {
		// Add current word to output array
		output[m] = arr[m][n];

		// If this is last word of current output sentence, then print
		// the output sentence
		if (m == arr.length - 1) {
			for (int i = 0; i < arr.length; i++) {
			//output stores the words to tell every sentence
				if(output[i]!=null)
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		// Recur for next row
//if all the words are finished increment the row.
		for (int i = 0; i < arr[0].length; i++)
			if (arr[m + 1][i] != "")
				printUtil(arr, m + 1, i, output);

	}

	public static void print(String arr[][]) {

		String output[] = new String[arr.length];

		// Consider all words for first row as starting points and
		// print all sentences
		for (int i = 0; i < arr[0].length; i++)
			if (arr[0][i] != null)
				printUtil(arr, 0, i, output);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		String arr[][] = new String[row][col];
		
		for(int i=0; i<arr.length; i++) {
			int noofcolineachrow=scn.nextInt();
			for(int j=0; j<noofcolineachrow; j++) {
				arr[i][j]=scn.next();
			}
		}

		print(arr);

	}
}
/*
Test cases:
	2 2
	2
	This is
	2 
	test case
	-----------------
	This test 
	This case 
	is test 
	is case 
	
	
	3 2
	2
	GEEK Nerd
	1  
	FOR
	2  
	GEEKS Nerds 
	--------------------
	GEEK FOR GEEKS 
	GEEK FOR Nerds 
	GEEK GEEKS 
	GEEK Nerds 
	Nerd FOR GEEKS 
	Nerd FOR Nerds 
	Nerd GEEKS 
	Nerd Nerds  

	3 2
	2
	Excel Improve
	2 
	With AlongWith
	2
	PepCoding Java
	--------------------
	Excel With PepCoding 
	Excel With Java 
	Excel AlongWith PepCoding 
	Excel AlongWith Java 
	Improve With PepCoding 
	Improve With Java 
	Improve AlongWith PepCoding 
	Improve AlongWith Java 
	
	
	Source: https://www.geeksforgeeks.org/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/
 */