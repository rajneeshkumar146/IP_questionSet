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
		int result = 0;
		// Pushing 1 to 9 because all number from 1
		// to 9 have this propert.
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= 9; i++) {

			if (i <= n) {
				s.push(i);
				result++;
			}
			// take a number from stack and add
			// a digit larger than last digit
			// of it.
			while (!s.empty()) {
				int tp = s.peek();
				s.pop();
				for (int j = tp % 10; j <= 9; j++) {
					int x = tp * 10 + j;
					if (x <= n) {
						s.push(x);
						result++;
					}
				}
			}
		}
		return result;
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