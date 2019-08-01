package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_54MedianOfTwoSortedArrays {
/* What : Given two sorted arrays of unequal sizes, find their median.
*         Efiiciently.
* How : We try to find a partition (x1, x2) and (y1, y2), such that x1 <= y2 and x2 >= y1. This ensures x2 and y2 are greater than  
 *x1 and y1. 
 *Also, we partition such that elements on lower half are exactly equal to(sum of array sizes is even) or one greater(sum of array sizes is odd) than those in upper half. 
* If such a partition is achieved, median(sum of array sizes is even) = avg(max(x1, y1), min(x2,y2)
 * Or median(sum of array sizes is odd) = max(x1, y1)
 *
 *
*/
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
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in
				// case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		// we can come here only if input arrays were not sorted. Throw in that
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
