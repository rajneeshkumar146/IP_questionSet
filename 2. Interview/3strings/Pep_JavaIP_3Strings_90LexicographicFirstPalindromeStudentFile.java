-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a string of lower alphabet characters.
2. You have to rearrange the characters of the given string,
   to form a palindromic string.
3. Print the lexicographically first palindromic string, if it exists,
   otherwise print Not Possible.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
import java.util.Scanner;

public class Pep_JavaIP_3Strings_90LexicographicFirstPalindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		boolean result = ispossible(str);
		if (result == true) {

			char[] str_array=new char[str.length()];//You have to develop this array
          	//code to print the lexicographically first palindromic string.


			for (char ch1 : str_array) {
				System.out.print(ch1);
			}
		} else {
			System.out.println("Not Possible");
		}

	}

	private static boolean ispossible(String str) {

	        //determines if it is possible to make a palindromic string

	}

}



/*
Test cases:
	malayalam
	-----------------
	aalmymlaa


	apple
	--------------------
	Not Possible


	nitin
	----------------------
	intni

	Source: https://www.geeksforgeeks.org/lexicographically-first-palindromic-string/
	*/
