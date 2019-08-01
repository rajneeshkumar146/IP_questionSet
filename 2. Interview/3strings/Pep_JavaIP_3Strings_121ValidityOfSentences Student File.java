--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a line. You have to print "Valid" if the line forms a
meaningful sentence according to given set of rules and "Invalid" otherwise.
2. The set of rules are:
1. Sentence must start with a Uppercase character (e.g. Noun/ I/ We/ He etc.)
2. Then lowercase character follows.
3. There must be spaces between words.
4. Then the sentence must end with a full stop(.) after a word.
5. Two continuous spaces are not allowed.
6. Two continuous upper case characters are not allowed.
7. However the sentence can end after an upper case character.
8. Camelcase words (some characters are in uppercase and others in lowercase)
are not allowed such as "PepCoding".
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_121ValidityOfSentences {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String line = scn.nextLine();

		// starting character must be capital and last character must be full stop
		if (line.charAt(0) < 'A' || line.charAt(0) > 'Z') {
			System.out.println("Invalid");
			return;
		}
		if (line.charAt(line.length() - 1) != '.') {
			System.out.println("Invalid");
			return;
		}
		char prevstate=line.charAt(0);
		checkvalidity(line, 1, prevstate);

	}

	private static void checkvalidity(String line, int vidx, char prevstate) {
		//function to check validity of given line
	}

}
/*
 * Test cases:
My name is Ram.
----------------------------
Valid

 The vertex is S.
 -----------------------
 Valid


GeeksQuiz. is a quiz site.
-------------------------------
Invalid

I love cinema
---------------------
Invalid


  Source:
 https://www.geeksforgeeks.org/check-given-sentence-given-set-simple-grammer-rules/


 */
