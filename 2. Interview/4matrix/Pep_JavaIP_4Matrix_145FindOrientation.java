package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_145FindOrientation {

	private static int[] computeTemporaryArray(char pattern[]) {
		int[] lps = new int[pattern.length];
		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public static boolean KMP(char[] text, char[] pattern) {

		int lps[] = computeTemporaryArray(pattern);
		int i = 0;
		int j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[scn.nextInt()][scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.next().charAt(0);
			}
		}
		String subString = scn.next();
		for (int i = 0; i < arr.length; i++) {
			if (KMP(arr[i], subString.toCharArray())) {
				System.out.println("Horizontal");
				return;
			}
		}

		for (int i = 0; i < arr[0].length; i++) {
			char[] col = new char[arr.length]; // each column is as longer as number of rows
			for (int j = 0; j < arr.length; j++) {
				col[j] = arr[j][i];
			}
			if (KMP(col, subString.toCharArray())) {
				System.out.println("Vertical");
				return;
			}
		}
	}

}

/*
Test cases:
	5 5
	a b c d e
	f g h i j
	k l m n o 
	p q r s t 
	u v w x y
	pqrs
	------------------
	Horizontal
	
	
	5 5
	a b c d e
	f g h i j
	k l m n o 
	p q r s t 
	u v w x y
	ejot
	------------------
	Vertical

	
	5 5
	a b c d e
	f g h i j
	k l m n o 
	p q r s t 
	u v w x y
	abcde
	------------------
	Horizontal

	Source: https://www.geeksforgeeks.org/find-orientation-of-a-pattern-in-a-matrix/
	*/