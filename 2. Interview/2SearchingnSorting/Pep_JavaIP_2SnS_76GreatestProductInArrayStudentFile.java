-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of positive integers.
2. You have to find the greatest number which is the product of two array elements, and
   that number should also be present in the array.
3. Print that number if it exists, otherwise print "-1".
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_76GreatestProductInArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

    //code to find the greatest product in array

	}

}

/*
 * Test cases:
 * 5
 * 17 2 1 35 30
 * ------------------
 * 35
 *
 *5
10 2 4 30 35
------------------
-1


 6
10 2  2 4 30 35
------------------
4

Source: https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/
 *
 *
 */
