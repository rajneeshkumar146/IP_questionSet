--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given n number of discs.
2. Solve tower of hanoi problem by iterative method.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_251IterativeTowerOfHanoi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofDisks = scn.nextInt();
		tohiterative('A', 'B', 'C', noofDisks);
	}

	private static class tohHelper {
		char s;
		char d;
		char h;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
		int noofdisks;

		public tohHelper(char s, char d, char h, boolean selfdone, boolean leftdone, boolean rightdone, int noofdisks) {
			this.s = s;
			this.d = d;
			this.h = h;
			this.selfdone = selfdone;
			this.leftdone = leftdone;
			this.rightdone = rightdone;
			this.noofdisks = noofdisks;
		}
	}

	private static void tohiterative(char s, char d, char h, int noofDisks) {

	}

}

/*
Test Cases:
3
---------------------------
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 3 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B

4
-------------------------
Move 1 from A to C
Move 2 from A to B
Move 1 from C to B
Move 3 from A to C
Move 1 from B to A
Move 2 from B to C
Move 1 from A to C
Move 4 from A to B
Move 1 from C to B
Move 2 from C to A
Move 1 from B to A
Move 3 from C to B
Move 1 from A to C
Move 2 from A to B
Move 1 from C to B


5
----------------------------
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 3 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B
Move 4 from A to C
Move 1 from B to C
Move 2 from B to A
Move 1 from C to A
Move 3 from B to C
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 5 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B
Move 3 from C to A
Move 1 from B to C
Move 2 from B to A
Move 1 from C to A
Move 4 from C to B
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 3 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B

Source: https://www.geeksforgeeks.org/iterative-tower-of-hanoi/



*/
