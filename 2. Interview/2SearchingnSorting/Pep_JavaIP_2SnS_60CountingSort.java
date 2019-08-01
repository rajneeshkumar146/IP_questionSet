package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_60CountingSort {
/* What : Sort an array in O(n). Resriction : Works only when array elements
* in specific range
*
*How :Build char count_array from string. Sum over count_array, now count_array[i]
*	represents how many elements come before this element in string.Iterate over
* string, put element at correct position and decrement count_array[i]
* WHY :
*Summing over count_array elements is crucial fact, this gives count of how many
*elements are less than equal to i. To make it a stable sort, start from end
*after modifying the count_array
*
 */
	// Sort an character array
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String input = scn.next();
		char[] arr = input.toCharArray();
		char[] output=new char[arr.length];
		// Now lets apply counting sort
		// Since string has only alphabets,assuming only lowercase stirng
		int[] count_array = new int[26];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i]-'a']++;
		}
		/*Sums over count array. Now eachi count_array[i] represents how many elements
		*come before this element in array
		*/
		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = 0; i < arr.length; i++) {
			// place each arr[i] at its correct position.
			if (count_array[arr[i]-'a'] >= 1) {
				/*Position is calulated due to the fact that count_array[i] stores how many elements
				*	come before it in string
				*/
				output[count_array[arr[i]-'a']-1] = (char) arr[i];
				count_array[arr[i]-'a']--;
			}
		}

		for (char ch : output) {
			System.out.print(ch);
		}
	}

}
/*

Test cases:
	geeksforgeeks
	-------------------
	eeeefggkkorss

	istanbulnewdelhi
	----------------------
	abdeehiillnnstuw

	quickbrownfoxjumpoverthelazydog
	--------------------------
	abcdeefghijklmnoooopqrrtuuvwxyz

	Source: https://www.geeksforgeeks.org/counting-sort/
	*/
