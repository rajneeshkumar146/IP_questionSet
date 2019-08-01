-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of size n.
2. This array contains numbers varying from 0 to n - 1.
   Any number can occur any number of times.
3. You have to find these repeating numbers.
    Time Complexity : O(n)
		Space : 0(1)
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_70FindDuplicates {

	static void printRepeating(int arr[], int size) {

     //code to print repeating numbers

	}

	// Driver program
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}
		int arr_size = arr.length;

		printRepeating(arr, arr_size);
	}
}

/*
  Test cases
  5
  1 2 3 1 2
  -----------------
  1 2

  10
  2 2 3 4 5 6 7 8 8 0
  -------------------------
  2 8


  10
  1 2 3 4 5 6 7 8 8 0
  -------------------------
  8

  Source:
  https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-
  space/
 */
