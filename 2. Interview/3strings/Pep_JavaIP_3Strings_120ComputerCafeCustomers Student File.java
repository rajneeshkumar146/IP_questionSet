--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given an integer, which represents total number of computers in a cafe.
2. You are given a string (sequence of uppercase letters). Each uppercase letter
occurs twice. The first occurrence indicates the arrival of a customer; the
second indicates the departure of that same customer.
3. If all the computer systems in the cafe are occupied, the customer immediately
leaves.
4. You have to print the count of customers which do not get computer.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_120ComputerCafeCustomers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int n=scn.nextInt();
		solve(str,n);
	}

	private static void solve(String str, int n) {
		//function to print the count of customers which do not get computer
	}

}
/*
Test cases:
ABBAJJKZKZ
2
----------------------
0


GACCBDDBAGEE
3
-----------------
1

ABBCCA
1
------------------------
2


	Source: https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 */
