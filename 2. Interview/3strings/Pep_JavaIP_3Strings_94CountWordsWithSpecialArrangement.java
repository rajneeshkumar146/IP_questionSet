package Strings;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_94CountWordsWithSpecialArrangement {
/* What : No of ways to form valid string of length n.
         valid string's ith character has 3 choices pick i-1 or i or i+1 char from input string

 * How : End chars have only two choices as i-1, i+1 chars not available. Slide window of three characters
         if all characters distinct choices available 3, two distinct-->2 , one distinct-->1       

 * Why : if all chars repeating ex: aaa, then character choice doesn't lead to a new string
        if two chars repeating ex: aab, then character choice leads to two strings,use either a or b
        if all distinct, ex: abc, then character choice leads to three strings, use a or b or c.
*/
	static int Cwords(String str, int len) {
		int count = 1;
		// We are taking count as the total no. of subsequences formed
		// till now.
		if (len == 1)
			return count;

		// if first and second element are equal.
		// count would be 1.
		if (str.charAt(0) == str.charAt(1))
			count *= 1;
		else
			count *= 2;
		// there are three cases,
		// suppose the input string is "abc"
		// options available for b are a,b and c i.e. three .
		// for string "aab" options for a in middle are only two i.e. 'a' and 'b'.
		for (int j = 1; j < len - 1; j++) {
			
			// if all are equal
			if (str.charAt(j) == str.charAt(j - 1) && str.charAt(j) == str.charAt(j + 1))
				count *= 1;
			
			// if(if two of them are equal.
			else if (str.charAt(j) == str.charAt(j - 1) || str.charAt(j) == str.charAt(j + 1)
					|| str.charAt(j - 1) == str.charAt(j + 1))
				count *= 2;
			
			// if all are distinct.
			else
				count *= 3;
		}

		if (str.charAt(len - 1) == str.charAt(len - 2))
			count *= 1;
		else
			count *= 2;

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
