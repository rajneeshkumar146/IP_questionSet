-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given two arrays of positive integers X and Y.
2. If x is an element of array X and y is an element of array Y,
   you have to find number of pairs such that (x^y) > (y^x).
3. Print the count of such pairs.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_69CountPairsXY {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int sizeofX = scn.nextInt();
		int[] X = new int[sizeofX];
		for (int i = 0; i < X.length; i++) {
			X[i] = scn.nextInt();
		}

		int[] Y = new int[scn.nextInt()];
	  int count = 0;



    //code to count pairs of X and Y such that
		//(x^y) > (y^x)



		System.out.println(count);
	}

	private static int ceil(int i, int[] y) {
		int lo = 0;
		int hi = y.length - 1;
		int pos = findceil(i, y, lo, hi);
		return pos;
	}

	private static int findceil(int i, int[] y, int lo, int hi) {


    //function to find ceil

	}

}


/*
Test cases:

3
10 19 18
3
11 15 9
--------------
2

3
2 1 6
2
1 5
----------------
2

3
10 19 8
3
11 15 9
--------------
5

Source: https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
*/
