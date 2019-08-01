-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given two sorted arrays of unequal length.
2. You have to find the median of these two given arrays.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_54MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int input1[], int input2[]) {
		// if input1 length is greater than switch them so that input1 is smaller than
		// input2.
		if (input1.length > input2.length) {
			return findMedianSortedArrays(input2, input1);
		}
		int x = input1.length;
		int y = input2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			// if partitionX is 0 it means nothing is there on left side. Use -INF for
			// maxLeftX
			// if partitionX is length of input then there is nothing on right side. Use
			// +INF for minRightX
      //Similarly for partitionY


			//code starts here





      //code ends here


				

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] x = new int[scn.nextInt()];
		for (int i = 0; i < x.length; i++) {
			x[i] = scn.nextInt();
		}
		int[] y = new int[scn.nextInt()];
		for (int i = 0; i < y.length; i++) {
			y[i] = scn.nextInt();
		}
		System.out.println(findMedianSortedArrays(x, y));
	}
}

/*
Test Cases:
5
1 3 8 9 15
6
7 11 18 19 21 25
---------------------------
11.0

4
23 26 31 35
6
3 5 7 9 11 16
----------------
13.5

1
1
2
1 3
--------------------
1.0


Source: https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/

*/
