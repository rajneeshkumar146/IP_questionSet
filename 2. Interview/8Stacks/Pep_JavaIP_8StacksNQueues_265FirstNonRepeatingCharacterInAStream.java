package Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_265FirstNonRepeatingCharacterInAStream {

	final static int CHAR_MAX = 26;

	// function to find first non repeating
	// character of stream
	static void firstNonRepeating(String str) {
		// count array of size 26(assuming only lower case characters are present)
		int[] charCount = new int[CHAR_MAX];

		// Queue to store Characters
		Queue<Character> q = new LinkedList<Character>();

		// traverse whole stream
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// push each character in queue
			q.add(c);

			// increment the frequency count
			charCount[c - 'a']++;

			// check for the non repeating character
			while (!q.isEmpty()) {
				if (charCount[q.peek() - 'a'] > 1)
					q.remove();
				else {
					System.out.print(q.peek() + " ");
					break;
				}
			}
			if (q.isEmpty())
				System.out.print(-1 + " ");
		}
		System.out.println();
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
 * Test cases: aabcdaabcbc ---------------------- a -1 b b b b b c d d d
 * 
 * geeksforgeeks ---------------------- g g g g g g g g k k k s f
 * 
 * pepcoding ---------------------- p p e e e e e e e
 * 
 * Source:
 * https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-
 * character-in-a-stream/
 */