-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of integers.
2. You have to make all values of this array equal to some integer value with minimum cost.
3. The cost of changing an array value x to y is abs(x-y).
   for eg : if we want to change 10 to 15, then its cost will be |10 - 15| = 5.
4. Print the minimum cost to make all array elements equal.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_64MinimumCostToMakeArrayElements {

	public static int computeCost(int arr[], int N, int X) {
		int cost = 0;
		for (int i = 0; i < N; i++)
			cost += Math.abs(arr[i] - X);
		return cost;
	}


	public static int minCostToMakeElementEqual(int arr[], int N) {

		// Method to find minimum cost to make all
	 // elements equal


		return computeCost(arr, N, (low + high) / 2);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}
		int N = arr.length;
		System.out.println(minCostToMakeElementEqual(arr, N));
	}

}
/*

Test cases:
5
1 2 3 4 5
------------------
6


8
1 2 3 4 25 36 49 50
--------------
150


4
12 3 4 5
----------------
10

	Source: https://www.geeksforgeeks.org/make-array-elements-equal-minimum-cost/



*/
