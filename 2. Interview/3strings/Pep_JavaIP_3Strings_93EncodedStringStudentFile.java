-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an encoded string where repetitions of substrings are represented as
   substring followed by count of substrings.
   For eg - for �ab2cd2� , decrypted string is �ababcdcd�.
2. You are also given an integer k.
3. Print the k-th character of decrypted string. 
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_93EncodedString {

	static char encodedChar(String str, int k) {
	

	     //function to find the k-th character of decrypted string. 
	     
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
