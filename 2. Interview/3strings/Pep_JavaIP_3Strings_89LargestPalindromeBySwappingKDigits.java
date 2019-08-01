package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_89LargestPalindromeBySwappingKDigits {
/* What : Form the largest(numeric) possible palindrome by changing atmost k digits
 * How : If possible to make it palindrome using k changes, then try to maximize the number.
 * Start from both ends, if digits unequal change them to max of both, change = change -1
 * If Changes left then try to make it larger number.
 * Why :Palindrome trick start from both ends, count changes required to make it palindrome.
 *  Odd length: if change left  then make middle digit 9
 * Even length: handled by left, right
 *
*/
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		int k= scn.nextInt();

		char[] str_array=str.toCharArray();
		char[] palin=new char[str_array.length];

		/*Check if string can be made palindrome with k changes
		* If x characters ar unequal then after iteration k = k - x
		*/
		int left=0;
		int right=str_array.length-1;
		while(left<=right) {
			if(str_array[left]!=str_array[right]) {
				palin[left]=(char) Math.max(str_array[left], str_array[right]);
				palin[right]=(char) Math.max(str_array[left], str_array[right]);
				k--;
			}else {
				palin[left]=str_array[left];
				palin[right]=str_array[left];
			}
			left++;
			right--;
		}

		if(k<0) {
			System.out.println("Not Possible");
			return;
		}

		//Now lets make changes for the largest palindrome possible
		left=0;
		right=str.length()-1;

		while(left<=right) {
			/*Odd length and swaps left, so put 9 in middle*/
			if(left==right) {
				if(k>0) {
					palin[left]='9';
				}
			}

			if(palin[left]<'9') {
				if(k>=2 && palin[left]==str_array[left] && palin[right]==str_array[right]) {
					//we didn't make any changes in first iteration, so change both digits
					palin[left]='9';
					palin[right]='9';
					k-=2;
				}
				else if(k>=1 && (palin[left]!=str_array[left] || palin[right] != str_array[right])) {
					/*Only one change made because we made changes in earlier iteration*/
					k-=1;
					palin[left]='9';
					palin[right]='9';
				}
			}

			left++;
			right--;
		}

		//Now we have to print it
		for(char ch: palin) {
			System.out.print(ch);
		}

	}

}
/*
Test cases:
	43435
	2
	-------------
	93439

	43435
	1
	----------------------
	53435


	12345
	1
	----------------------
	Not Possible

	Source:https://www.geeksforgeeks.org/make-largest-palindrome-changing-k-digits/
	*/
