package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_398OnlineAlgoPalindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		printpalindromecharacterbycharacter(s);
	}

	private static void printpalindromecharacterbycharacter(String s) {

		System.out.println(s.charAt(0) + " Yes");
		int first = s.charAt(0);
		int second = s.charAt(1);
		if (ispalindrome(s, 0, 1)) {
			System.out.println(s.charAt(1) + " Yes");
		} else {
			System.out.println(s.charAt(1) + " No");
		}
		for (int i = 2; i < s.length(); i++) {
			if (i % 2 == 0) {
				first += s.charAt(i / 2);
				second += s.charAt(i);
				if (first == second) {
					if (ispalindrome(s, 0, i)) {
						System.out.println(s.charAt(i) + " Yes");
					} else {
						System.out.println(s.charAt(i) + " No");
					}
				} else {
					System.out.println(s.charAt(i) + " No");
				}

			} else {

				second -= s.charAt(i / 2);
				second += s.charAt(i);
				if (first == second) {
					if (ispalindrome(s, 0, i)) {
						System.out.println(s.charAt(i) + " Yes");
					} else {
						System.out.println(s.charAt(i) + " No");
					}
				} else {
					System.out.println(s.charAt(i) + " No");
				}

			}
		}
	}

	private static boolean ispalindrome(String s, int i, int i2) {
		int left = i;
		int right = i2;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
/*
abbaaa
a Yes
b No
b No
a Yes
a No
a No

	
aabaa
a Yes
a Yes
b No
a No
a Yes

aabaacaabaa
a Yes
a Yes
b No
a No
a Yes
c No
a No
a No
b No
a No
a Yes
  
  
  Source:
 https://www.geeksforgeeks.org/online-algorithm-for-checking-palindrome-in-a-
  stream/
 */