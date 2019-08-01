package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_104LargestWordinDictionary {
/* What :Given a string and dictionary, find largest word from dictionary which is subsequence of string
 * How : Iterate over dictionary words, if current word is larger than subsequence found
 * so far,update  
 * Why : Problem reduces to finding is given word subsequence of string
 *
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);
		 ArrayList<String> arr=new ArrayList<String>();
		 int n=scn.nextInt();
		 for(int i = 0; i < n; i++) {
			 arr.add(scn.next());
		 }
		 String str=scn.next();
		 String res=getprob(arr,str);
		 System.out.println(res);

	}
	public static String getprob(ArrayList<String> arr, String str) {
		 String result = "";
		    int length = 0;

		    // Traverse through all words of dictionary
		    for (String word : arr)
		    {
		        // If current word is subsequence of str and is largest
		        // such word so far.
		        if (length < word.length() && isSubSequence(word, str,word.length(),str.length()))
		        {
		            result = word;
		            length = word.length();
		        }
		    }

		    // Return longest string
		    return result;
			}
	/*Is string1 subsequence of string2 ? */
	static boolean isSubSequence(String str1, String str2, int m, int n)
    {
        int j = 0;

        //traverse both the strings by j and i.
        //j is for the smaller string
        //i is for the greater string.

        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;

        // If all characters of str1 were found in str2
        return (j==m);
        //if j becomes the length of the string ,then
        //subsequence is proved.

    }

}




/*
Test cases:
	4
	ale
	apple
	jkl
	ll
	aljdkpplxmnnbe
	----------------------
	apple

	3
	aefh
	ae
	axt
	abcdefgh
	----------------------
	aefh


	6
	aefghd
	fhsjkak
	ncnnc
	aefg
	xysnzj
	apple
	abcdefghdd
	----------------------
	aefghd

	Source: https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/
	*/
