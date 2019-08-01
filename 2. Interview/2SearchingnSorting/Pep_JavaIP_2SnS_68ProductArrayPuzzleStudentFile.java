-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of n integers.
2. You have to construct a product array (of same size) such that, i-th element of product array
   is equal to the product of all the elements of given array except i-th element of given array.
	 Note - divison operator is not allowed.
3. Print the product array.
	 Target Complexity : O(n)
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_68ProductArrayPuzzle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}


      //code to create product array



		for(int val: arr) {
			System.out.print(val+" ");
		}

	}

}

/*
Test cases
5
10 3 5 6 2
-------------------
180 600 360 300 900

5
13 14 -15 17 -16
------------------
57120 53040 -49504 43680 -46410


10
1 2 3 -4 -5 6 7 8 9 10
-------------------------
3628800 1814400 1209600 -907200 -725760 604800 518400 453600 403200 362880

Source: https://www.geeksforgeeks.org/a-product-array-puzzle/
*/
