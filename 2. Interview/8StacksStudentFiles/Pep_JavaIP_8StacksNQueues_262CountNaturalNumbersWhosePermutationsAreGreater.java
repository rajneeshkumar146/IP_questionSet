--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given an integer n.
2. You have to count all such numbers from 1 to n,
   whose all permutations are greater than the number itself.
For eg : 123 is one such number whose all permutations are greater than it.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_262CountNaturalNumbersWhosePermutationsAreGreater {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(countNumber(n));
		scn.close();
	}

	// permutation greater than or equal to the number.
	static int countNumber(int n) {
	
	}
}
/*
 15
 -----------------------
 14

 100
 ---------------------------
 54

 200
 -------------------
 99

Source: https://www.geeksforgeeks.org/count-natural-numbers-whose-permutation-greater-number/*/
