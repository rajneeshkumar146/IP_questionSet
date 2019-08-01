package SearchingSorting;

import java.util.Scanner;
import java.util.Arrays;

public class Pep_JavaIP_2SnS_64MinimumCostToMakeArrayElements {
	/* What : Given an array, change all of its elements to X such that
	* sum is minimized |arr[i] - X|	, where i = 0 to arr.length-1
	*
	* How : Sort the array, calcuate median. Calculate cost.
	*
	* Why :Plot the elements of array on number line, now we have to move each i
	* some distance Di, such that they all converge at one single point, X.
	* Our goal is to minimize sum(Di), i = 0 to arr.length-1.
	*	This is the DEFINITION of geometric median, which in the case of 1-D space
	* coincides with median.
	*
	*/
	public static int computeCost(int arr[], int X) {
		int cost = 0;
		for (int i = 0; i < arr.length; i++)
			cost += Math.abs(arr[i] - X);
		return cost;
	}

	/*Computes median, as it gives minimum cost*/
	public static int minCostToMakeElementEqual(int arr[]) {
		Arrays.sort(arr);
		int median = 0;
		if(arr.length % 2 != 0){
			median = arr[arr.length / 2];
		}else{
			median = (arr[arr.length/2] + arr[(arr.length/2) - 1]) / 2;
		}
		int cost = computeCost(arr,median);
		return cost;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}

		System.out.println(minCostToMakeElementEqual(arr));
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
