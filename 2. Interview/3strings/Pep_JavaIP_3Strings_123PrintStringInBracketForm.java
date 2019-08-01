package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_123PrintStringInBracketForm {
	
	public static void main(String[] args) {
		// input string
		Scanner scn=new Scanner(System.in);
		String str = scn.next();
		findCombinations(str,"");
	}

	private static void findCombinations(String ques, String answer) {
		if(ques.length()==0) {
		//return the answer  when the length becomes equal to the ques length.
			System.out.println(answer);
			return;
		}
		
		for(int i=0; i<ques.length(); i++) {
		//adding the brackets one by one at every position.
		//recursive call to reduce question and changes in answer by adding brackets to rest substrings.
		//reducing ques. by 1.                                                                    brackets closed substring.
			findCombinations(ques.substring(i+1), answer+"("+ques.substring(0, i+1)+")");
		}
		// for example doing this for a and then b,ab=(a)(b),(ab)
	}

}

/*
Test cases:
abcd
----------
(a)(b)(c)(d)
(a)(b)(cd)
(a)(bc)(d)
(a)(bcd)
(ab)(c)(d)
(ab)(cd)
(abc)(d)
(abcd)

abc
-----------------
(a)(b)(c)
(a)(bc)
(ab)(c)
(abc)



	abcdefgh
	------------------------
	(a)(b)(c)(d)(e)(f)(g)(h)
(a)(b)(c)(d)(e)(f)(gh)
(a)(b)(c)(d)(e)(fg)(h)
(a)(b)(c)(d)(e)(fgh)
(a)(b)(c)(d)(ef)(g)(h)
(a)(b)(c)(d)(ef)(gh)
(a)(b)(c)(d)(efg)(h)
(a)(b)(c)(d)(efgh)
(a)(b)(c)(de)(f)(g)(h)
(a)(b)(c)(de)(f)(gh)
(a)(b)(c)(de)(fg)(h)
(a)(b)(c)(de)(fgh)
(a)(b)(c)(def)(g)(h)
(a)(b)(c)(def)(gh)
(a)(b)(c)(defg)(h)
(a)(b)(c)(defgh)
(a)(b)(cd)(e)(f)(g)(h)
(a)(b)(cd)(e)(f)(gh)
(a)(b)(cd)(e)(fg)(h)
(a)(b)(cd)(e)(fgh)
(a)(b)(cd)(ef)(g)(h)
(a)(b)(cd)(ef)(gh)
(a)(b)(cd)(efg)(h)
(a)(b)(cd)(efgh)
(a)(b)(cde)(f)(g)(h)
(a)(b)(cde)(f)(gh)
(a)(b)(cde)(fg)(h)
(a)(b)(cde)(fgh)
(a)(b)(cdef)(g)(h)
(a)(b)(cdef)(gh)
(a)(b)(cdefg)(h)
(a)(b)(cdefgh)
(a)(bc)(d)(e)(f)(g)(h)
(a)(bc)(d)(e)(f)(gh)
(a)(bc)(d)(e)(fg)(h)
(a)(bc)(d)(e)(fgh)
(a)(bc)(d)(ef)(g)(h)
(a)(bc)(d)(ef)(gh)
(a)(bc)(d)(efg)(h)
(a)(bc)(d)(efgh)
(a)(bc)(de)(f)(g)(h)
(a)(bc)(de)(f)(gh)
(a)(bc)(de)(fg)(h)
(a)(bc)(de)(fgh)
(a)(bc)(def)(g)(h)
(a)(bc)(def)(gh)
(a)(bc)(defg)(h)
(a)(bc)(defgh)
(a)(bcd)(e)(f)(g)(h)
(a)(bcd)(e)(f)(gh)
(a)(bcd)(e)(fg)(h)
(a)(bcd)(e)(fgh)
(a)(bcd)(ef)(g)(h)
(a)(bcd)(ef)(gh)
(a)(bcd)(efg)(h)
(a)(bcd)(efgh)
(a)(bcde)(f)(g)(h)
(a)(bcde)(f)(gh)
(a)(bcde)(fg)(h)
(a)(bcde)(fgh)
(a)(bcdef)(g)(h)
(a)(bcdef)(gh)
(a)(bcdefg)(h)
(a)(bcdefgh)
(ab)(c)(d)(e)(f)(g)(h)
(ab)(c)(d)(e)(f)(gh)
(ab)(c)(d)(e)(fg)(h)
(ab)(c)(d)(e)(fgh)
(ab)(c)(d)(ef)(g)(h)
(ab)(c)(d)(ef)(gh)
(ab)(c)(d)(efg)(h)
(ab)(c)(d)(efgh)
(ab)(c)(de)(f)(g)(h)
(ab)(c)(de)(f)(gh)
(ab)(c)(de)(fg)(h)
(ab)(c)(de)(fgh)
(ab)(c)(def)(g)(h)
(ab)(c)(def)(gh)
(ab)(c)(defg)(h)
(ab)(c)(defgh)
(ab)(cd)(e)(f)(g)(h)
(ab)(cd)(e)(f)(gh)
(ab)(cd)(e)(fg)(h)
(ab)(cd)(e)(fgh)
(ab)(cd)(ef)(g)(h)
(ab)(cd)(ef)(gh)
(ab)(cd)(efg)(h)
(ab)(cd)(efgh)
(ab)(cde)(f)(g)(h)
(ab)(cde)(f)(gh)
(ab)(cde)(fg)(h)
(ab)(cde)(fgh)
(ab)(cdef)(g)(h)
(ab)(cdef)(gh)
(ab)(cdefg)(h)
(ab)(cdefgh)
(abc)(d)(e)(f)(g)(h)
(abc)(d)(e)(f)(gh)
(abc)(d)(e)(fg)(h)
(abc)(d)(e)(fgh)
(abc)(d)(ef)(g)(h)
(abc)(d)(ef)(gh)
(abc)(d)(efg)(h)
(abc)(d)(efgh)
(abc)(de)(f)(g)(h)
(abc)(de)(f)(gh)
(abc)(de)(fg)(h)
(abc)(de)(fgh)
(abc)(def)(g)(h)
(abc)(def)(gh)
(abc)(defg)(h)
(abc)(defgh)
(abcd)(e)(f)(g)(h)
(abcd)(e)(f)(gh)
(abcd)(e)(fg)(h)
(abcd)(e)(fgh)
(abcd)(ef)(g)(h)
(abcd)(ef)(gh)
(abcd)(efg)(h)
(abcd)(efgh)
(abcde)(f)(g)(h)
(abcde)(f)(gh)
(abcde)(fg)(h)
(abcde)(fgh)
(abcdef)(g)(h)
(abcdef)(gh)
(abcdefg)(h)
(abcdefgh)
	
	
	
	
	Source: https://www.geeksforgeeks.org/print-ways-break-string-bracket-form/
 */
