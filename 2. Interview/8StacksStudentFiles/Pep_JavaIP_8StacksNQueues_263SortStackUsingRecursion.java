--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given a stack of integers.
2. You have to sort the given stack using recursion such that
   the number at top of the stack should be the greatest number.
	 For eg : A stack is represented by : 1 2 4 5 3
	 Sorted stack will be : 1 2 3 4 5, where 5 is at top of the stack.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_263SortStackUsingRecursion {

	static void sortedInsert(Stack<Integer> s, int x) {

	}

	// Method to sort stack
	static void sortStack(Stack<Integer> s) {

	}

	// Utility Method to print contents of stack
	static void printStack(Stack<Integer> s) {
		
	}

	// Driver method
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		for (int i = 0; i < size; i++) {
			s.push(scn.nextInt());
		}


		sortStack(s);

		printStack(s);

	}

}


/*Test Cases:
5
-3 14 18 -5 30
---------------
30 18 14 -3 -5

10
1 -1 2 -2 3 -3 4 -4 5 -5
------------------
5 4 3 2 1 -1 -2 -3 -4 -5

10
12 1 23 22 24 11 2 3 4 5
--------------------
24 23 22 12 11 5 4 3 2 1

Source: https://www.geeksforgeeks.org/sort-a-stack-using-recursion/

*/
