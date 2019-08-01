package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_398OnlineAlgoPalindrome {

/**
* We apply the rolling hash idea from Rabin-Karp Algorithm
* ex : if h(Si) = 48902, then to calculate h(Si+1) = 89021
* S0 = [4,8,9,0,2] and S1 = [8,9,0,2,1] 
* H(S0) = (4 * 10^4 + 8 * 10^3 + 9 * 10^2 + 0 * 10^1 + 2 * 10^0)modM
* In general 
* H(k) ={(k[0]*(b ^L−1) + k[1]*(b ^ L−2) + k[2]*(b ^ L−3)...k[L − 1]*(b ^ 0)}mod M
* we drop 48,902 - 40000 = 8902 * 10 - 89020 + 1 = 89021
* Rolling Hash formula : H(Si+1) = { b*(H(Si) - b^(L-1) * S[i]) + S[i+L] }modM
* where b = base, in strings we take 26
* L = length of pattern
* M = prime number
*  
*/

/**
 * Since we are checking palindromes , modify the hashing function slightly
 * Two cases : when i is odd and i is even 
 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		printpalindromecharacterbycharacter(s);
	}

	private static void printpalindromecharacterbycharacter(String s) {

		System.out.println(s.charAt(0) + " Yes");
		/**
		 * Hash of reverse of first half  = firstr
		 * Hash of second half = second
		 */
		int first = s.charAt(0);
		int second = s.charAt(1);
		
		/**
		 * If 'firstr' == second then we check for palindrome
		 */
		 if (ispalindrome(s, 0, 1)) {
			System.out.println(s.charAt(1) + " Yes");
		} else {
			System.out.println(s.charAt(1) + " No");
		}
		
		/**
		 * Compute next hashes from firstr and second
		 * Based on odd or even value of i, we compute hashes of next parts.
		 */
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