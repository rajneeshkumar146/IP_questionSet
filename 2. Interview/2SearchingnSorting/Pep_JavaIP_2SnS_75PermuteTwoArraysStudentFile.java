-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given two arrays of equal size n and an integer k.
2. You have to permute both arrays such that sum of their corresponding element is greater than or equal to k
   i.e a[i] + b[i] >= k.
3. Print "Yes" if any such permutation exists, otherwise print "No".
   Target Complexity : O(nlogn).	 
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_75PermuteTwoArrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}


		//code to permute two arrays

	}

}
/*
Test cases:
3
2 1 3
7 8 9
10
-----------------
Yes


4
2 1 6 5
4 7 8 9
10
----------------
Yes

6
10 19 8 11 15 9
6 5 4 3 2 1
20
--------------
No

Source: https://www.geeksforgeeks.org/permute-two-arrays-sum-every-pair-greater-equal-k/
*/
