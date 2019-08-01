--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given 2 integers : row and column.
2. You are then given row number of lists. Each list is of variable size. size of
 each list is greater than 0 and less than column.
3. You have to first take input of the size of the list and then take size number
of words as input.
4. You have to print all possible sentences such that each list contributes one
word to the list.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_130PrintAllSentencesPossible {

	public static void print(String arr[][]) {
		//function to print all possible sentences such that each list contributes one
		//word to the list.

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
