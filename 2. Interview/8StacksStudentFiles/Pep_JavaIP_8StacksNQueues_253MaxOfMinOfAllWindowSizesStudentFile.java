--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given an integer array of size n.
2. You have to find the maximum of the minimum’s of every window size in the array.
Note ->  Window size varies from 1 to n.
For eg : for a given array 10 20 30 50 10 70 30
Output will be 70 30 20 10 10 10 10
where, the first element in output indicates maximum of minimums of all
windows of size 1,
second element in output indicates maximum of minimums of all
windows of size 2, and so on.

--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_253MaxOfMinOfAllWindowSizes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int[] ans = maxOfMinsOfAllWindows(arr);

		for (int i = 1; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] maxOfMinsOfAllWindows(int[] arr) {



	}

	public static int[] nextSmallerElement(int[] arr) {



	}

	public static int[] prevSmallerElement(int[] arr) {



	}

}

/*Test Cases:

3
10 20 30
-------------
30 20 10


7
10 20 30 50 10 70 30
---------------
70 30 20 10 10 10 10

7
90 20 30 50 10 70 30
------------------
90 30 20 20 10 10 10

Source: https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/

*/
