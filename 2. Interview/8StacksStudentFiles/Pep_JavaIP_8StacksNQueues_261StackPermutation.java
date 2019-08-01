--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given two arrays, both of unique elements.
2. One represents the input queue and the other represents the output queue.
3. You have to check if the given output is possible through stack permutation or not.
4. Stack permutation is a permutation of objects in the given input queue
   which is done by transferring elements from input queue to the output queue
   with the help of a stack and the built-in push and pop functions.
5. Print Yes if given output queue is a stack permutation of given input queue,
   otherwise print Not Possible.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_261StackPermutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int[] output_arr = new int[arr.length];
		for (int i = 0; i < n; i++) {
			output_arr[i] = scn.nextInt();
		}

		//  Print Yes if given output queue is a stack permutation of given input queue,
		 //  otherwise print Not Possible


	}

}

/*
3
1 2 3
3 1 2
-------------------
Not Possible


3
1 2 3
2 1 3
-------------------
Yes

6
10 54 55 20 30 40
55 54 10 20 40 30
-------------------
Yes

Source:
*/
