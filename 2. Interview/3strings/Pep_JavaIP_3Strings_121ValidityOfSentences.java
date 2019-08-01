package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_121ValidityOfSentences {
	//code is too simple as it follows the given grammar rules. 
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
		//otherwise make call for the rest of teh string.
		char prevstate=line.charAt(0);
		checkvalidity(line, 1, prevstate);

	}

	private static void checkvalidity(String line, int vidx, char prevstate) {
		if(vidx==line.length()) {
			System.out.println("Valid");
			return;
		}
	//all conditions are checked one by one.if the start of the word is Captial letter then remaining letters in the word should be small.
		if(prevstate>='A' && prevstate<='Z') {
	//three choices are there if previous letter is uppercase, it can be smaller case, space or a full stop.

			if((line.charAt(vidx) >= 'a' && line.charAt(vidx) <= 'z') || line.charAt(vidx)==' ' || line.charAt(vidx)=='.') {
				//prevstate becomes new character .
				prevstate=line.charAt(vidx);
				checkvalidity(line, vidx+1, prevstate);
		
			}else {
				System.out.println("Invalid");
				return;
			}
		}
	//if prev is lowercase , then next  element could be a full stop , of lower case, or a space.
		else if(prevstate>='a' && prevstate<='z') {
			if(line.charAt(vidx)==' ' || line.charAt(vidx)=='.' || (line.charAt(vidx) >= 'a' && line.charAt(vidx) <= 'z')) {
				prevstate=line.charAt(vidx);
				checkvalidity(line, vidx+1, prevstate);
			}else {
				System.out.println("Invalid");
				return;
			}
		}else if(prevstate==' ') {
		// after space the character becomes equal to the character that lie between a-z and A-Z.

			if((line.charAt(vidx) >= 'a' && line.charAt(vidx) <= 'z') || (line.charAt(vidx) >= 'A' && line.charAt(vidx) <= 'Z')) {
				prevstate=line.charAt(vidx);
				checkvalidity(line, vidx+1, prevstate);
			}else {
				System.out.println("Invalid");
				return;
			}
		}else {
			if(line.charAt(vidx)==' ') {
			
				prevstate=line.charAt(vidx);
				checkvalidity(line, vidx+1, prevstate);
			}else {
				System.out.println("Invalid");
				return;
			}
		}
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


