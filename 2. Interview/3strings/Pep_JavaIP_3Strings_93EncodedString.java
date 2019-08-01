package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_93EncodedString {
/* What : kth character of encoded string: ab2cd3
 * How :  Expand the input string , find frequency of repetition f append substring f times to decoded string.   
 * Why : ab2cd3-->decode-->ababcdcdcd, return kth character
*/
	static char encodedChar(String str, int k) {

		// string which has to be returned.
		String expand = "";
		
		// string which will be created after evry num.
		String temp = "";

		// number which is present after evry sub -non integer string.
		int num = 0;

		for (int i = 0; i < str.length();) {
			temp = "";
			num = 0;

			// making the string in temp that is present before the next number.

			while (i < str.length() && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {

				temp += str.charAt(i);
				i++;
			}
			// storing the number in num.

			while (i < str.length() && str.charAt(i) >= '1' && str.charAt(i) <= '9') {

				num = num * 10 + str.charAt(i) - '0';
				i++;
			}

			for (int j = 1; j <= num; j++)
				expand += temp;
			// resultant string: expand

		}
		// if 0 ,add only once
		if (num == 0)
			expand += temp;
		// return the last charcter.
		return expand.charAt(k - 1);
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		System.out.println(encodedChar(str, k));
	}

}

/*Test Cases: 
ab4c2d4
5
---------------
a

abcdef
5
------------------
e


ggsipu4pepcoding8
64
--------------------
c

Source: https://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/

*/
