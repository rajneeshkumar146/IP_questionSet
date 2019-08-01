-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of strings, which represents a dictionary.
2. You are also given a string str.
3. You have to find the longest string in dictionary which can be formed by
   deleting some characters of the given �str�.
4. Print the longest string.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_104LargestWordinDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);
		 ArrayList<String> arr=new ArrayList<String>();
		 int n=scn.nextInt();
		 for(int i=0;i<n;i++) {
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

		    }

		    // Return longest string
		    return result;
	}
	static boolean isSubSequence(String str1, String str2)
    {

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
