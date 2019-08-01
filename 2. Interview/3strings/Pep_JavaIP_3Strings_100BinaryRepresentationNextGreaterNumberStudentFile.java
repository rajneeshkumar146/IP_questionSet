-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a string of 0's and 1's, which is the binary representation of any positive number n.
2. You have to find out the next greater number which has same number of 0's and 1's in its binary representation.
3. Print the binary representation of that number if it exists,
   otherwise print -1.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_100BinaryRepresentationNextGreaterNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String bnum = scn.next();
		System.out.println(nextGreaternumber(bnum));
	}

	private static String nextGreaternumber(String bnum) {
		int l = bnum.length();
		int i = 0;
		for (i = l - 2; i >= 0; i--) {
			// locate first 'i' from end such that
			// bnum[i]=='0' and bnum[i+1]=='1'
			// swap these value and break;

		
			}
		}

		// if no swapping performed
		if (i == -1) {
			return "-1";
		}
		// Since we want the smallest next value,
		// shift all 1's at the end in the binary
		// substring starting from index 'i+2'


		

		// required next greater number
		return bnum;
	}

}

/*
Test cases:
	10010
	-------------------
	10100

	11000001110
	----------------------
	11000010011

	11111111111
	----------------------
	-1

	Source: https://www.geeksforgeeks.org/binary-representation-next-greater-number-number-1s-0s/
	*/
