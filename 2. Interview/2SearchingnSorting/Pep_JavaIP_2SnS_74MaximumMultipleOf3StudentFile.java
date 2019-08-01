-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of integers.
2. You have to find the largest number that can be made from
   some or all numbers of array and is divisible by 3. 	 
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_74MaximumMultipleOf3 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[] arr1 = new int[scn.nextInt()];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}

     //code to print the largest number that can be made from
		 //some or all digits of array and is divisible by 3

	}

}

/*

Test cases:
4
5 5 5 7
------------------
555


8
1 2 3 4 25 36 49 50
--------------
493625431


4
12 3 4 5
----------------
12543

Source: https://www.geeksforgeeks.org/find-largest-multiple-3-array-digits-set-2-time-o1-space/
*/
