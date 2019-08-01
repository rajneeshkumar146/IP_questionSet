-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of n distinct integers.
2. You have to check whether reversing at most one sub-array would make the complete array sorted or not.
3. Print Yes if reversing at most one sub-array make the complete array sorted,
   otherwise print No.
	 Target Complexity : O(nlogn)).
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_65ReverseSorted {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		int[] output = new int[arr.length];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
			output[i1] = arr[i1];
		}

		//code to determine whether reversing one sub-array
		// make the complete array sorted or not

}

/*
 Test cases
4
2 5 3 4
--------------
No

5
13 14 15 17 16
------------------
Yes


10
1 2 3 4 5 6 7 8 9 10
-------------------------
Yes

Source: https://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/

 */
