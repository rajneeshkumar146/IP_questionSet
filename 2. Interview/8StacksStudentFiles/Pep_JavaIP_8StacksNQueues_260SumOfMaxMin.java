--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given an array of integers.
2. You are also given an integer k.
3. You have to compute sum of minimum and maximum elements of all sub-array of size k.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_260SumOfMaxMin {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k=scn.nextInt();

		//code
	}


}

/*
7
2 5 -1 7 -3 -1 -2
4
--------------------------
18


7
12 1 78 90 57 89 56
3
-------------------
609


6
10 54 -1 20 30 40
3
-------------------
195

Source: https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/

*/
