-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a string of length n.
2. You have to count number of valid strings that can be formed from the given string,
   where valid string is defined as:
   a. It should be of same length as given string.
   b. Character at ith position can be (i-1)-th, i-th, or (i+1)-th position letter of given
      string.
3. You have to print the count of valid strings possible.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
import java.util.Scanner;

public class Pep_JavaIP_3Strings_94CountWordsWithSpecialArrangement {

	static int Cwords(String str, int len) {
		int count = 1;
		//return count of words

        return count;
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int len = str.length();
		System.out.println(Cwords(str, len));
	}
}

/*Test Cases:

ab
---------------
4

abcdef
------------------
324


ggsipupepcoding
--------------------
944784

Source: https://www.geeksforgeeks.org/count-words-whose-th-letter-either-1-th-th-i1-th-letter-given-word/

*/
