--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given a 2-D matrix arr of size n * n containing only 0 and 1,
   n = number of persons
	 if arr[i][j] == 1 , implies Person i know Person j, and
	 if arr[i][j] == 0 , implies Person i doesn't know Person j.
2. You have to find celebrity(a person who is known by everyone and doesn't know anyone)
   among these n persons, in minimum number of knows() call.
3. Print index of celebrity if it exists, otherwise print -1.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_250CelebrityProblem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = scn.nextInt();
		}

		System.out.println(celebrity(arr));

	}

	private static int celebrity(int[][] arr) {

   //code

	}

	private static boolean knows(int[][] arr, int val1, int val2) {
		if (arr[val1][val2] == 1) {
			return true;
		}
		return false;
	}

}
/**
 * Test Cases
4 4
1 1 1 1
0 1 0 0
0 1 1 1
0 1 0 1
--------------
1

````````````````````````````````````````````
4 4
1 0 0 0
1 1 0 0
1 1 1 1
1 0 0 1
-------------------------
0

```````````````````````````````````````````````````
4 4
1 0 1 1
1 1 0 0
1 1 1 1
1 0 0 1
-------------------------
-1
  Source : https://www.geeksforgeeks.org/the-celebrity-problem/
 */
