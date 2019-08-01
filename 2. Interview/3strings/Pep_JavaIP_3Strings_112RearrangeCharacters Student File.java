--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a string and a positive integer d.
2. You have to rearrange characters of the string such that similar characters
are at least d distance away from each other.
3. If no such rearrangement is possible, print Not Possible.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_112RearrangeCharacters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int d = scn.nextInt();
		rearrange(str, d);
	}

	public static void rearrange(String str, int d) {
		//function to rearrange characters
	}

}

/*
Test cases:
	aaabb
	2
	-------------
	ababa

	geeksforgeeeks
	2
	----------------------
	egegesesekrkfo


	worldisallaboutmoney
	3
	----------------------
	loaloalomwutyrednsib


	geeks
	6
	-------------------
	Not Possible
	Source: https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
	*/
