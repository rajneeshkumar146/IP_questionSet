--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given an array of numbers.
2. You have to make an arraylist of those numbers which contains 1,2 and 3
digits.
3. You have to print that arraylist.
4. All the numbers in the arraylist must be in ascending order.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_116SortNumbersContaining123Only {

	private static ArrayList<Integer> printNumbers(int[] numbers)
    {
				//function to make a list of numbers with 1,2,3 digits
				//That list must contain numbers in ascending order
				//return the arraylist of numbers
    }

    // convert the number to string and find
    // if it contains 1, 2 & 3.
    private static boolean findContainsOneTwoThree(
                                         int number)
    {

    }

    public static void main(String[] args)
    {
    	Scanner scn=new Scanner(System.in);
    	int size=scn.nextInt();
    	int[] numbers=new int[size];
    	for(int i=0; i<size; i++) {
    		numbers[i]=scn.nextInt();
    	}
        System.out.println(printNumbers(numbers));
    }

}

/*
Test cases:

5
123 234 456 321 32145
---------------
[123, 321, 32145]

4
9821 627183 12 1234
----------------------------
[1234, 627183]


4
12 232 456 234
---------------------------
[]


	Source: https://www.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/
 */
