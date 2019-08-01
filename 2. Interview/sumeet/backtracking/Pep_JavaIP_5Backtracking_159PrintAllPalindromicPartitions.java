package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_159PrintAllPalindromicPartitions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		length = str.length();
		printPalind(str, "", "", 0);
	}

	static int length;
	public static void printPalind(String ques, 
								   String ans, 
								   String prefix, 
								   int count) {
		if (ques.length() == 0) {
			// count is there to count spaces in ans
			// length is original ques length
			if (count + length == ans.length()) {
				// removing the last space
				if(ans.length() > 0){
					ans = ans.substring(0, ans.length() - 1);
				}
				
				System.out.println(ans);
			}
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		// If the prefix + ch is a palindrome, 
		// there is an option to become part of word
		if (IsPalindrome(prefix + ch) == true) {
			printPalind(ros, ans + prefix + ch + " ", "", count + 1);
		}
		// else, there is no choice but to get added to prefix
		printPalind(ros, ans, prefix + ch, count);
	}

	private static boolean IsPalindrome(String str) {
		for (int left = 0, right = str.length() - 1; left < right; left++, right--) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
		}

		return true;
	}

}
