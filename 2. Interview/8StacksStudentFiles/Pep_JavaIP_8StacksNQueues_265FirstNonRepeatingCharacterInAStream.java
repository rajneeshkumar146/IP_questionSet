--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given a string.
2. You have to print the first non-repeating character in the string upto i,
    where i varies from 0 to str.length() - 1.
For eg : for given string -> aabc
the output will be :
a -> a
a a -> -1
a a b -> b
a a b c -> b

--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_265FirstNonRepeatingCharacterInAStream {

	final static int CHAR_MAX = 26;

	// function to find first non repeating
	// character of stream
	static void firstNonRepeating(String str) {


	}

	// Driver function
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		firstNonRepeating(str);
		scn.close();
	}

}

/*
 * Test cases:
 aabcdaabcbc
 ----------------------
 a -1 b b b b b c d d d
 *
 *
 geeksforgeeks
 ----------------------
 g g g g g g g g k k k s f
 *
 *
 pepcoding
 ----------------------
 p p e e e e e e e
 *
 * Source:
 * https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-
 * character-in-a-stream/
 */
