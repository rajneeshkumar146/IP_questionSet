package OrderStatsHeapHash;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_411CheckPairsDivisibleByK {
/**
 * Odd length can't be made divisible in pairs
 * For even length check 3 cases.
 * 0 modulus : even frequency
 * k/2 modulus: even frequency
 * i and k-i modulus : equal frequency
 * As our goal is to partition array in pairs such that
 * all pairs have their sum as divisible by k
 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		/**
		 * Key : remainder
		 * Value : frequency of remainder
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			int rem = val % k;
			if (map.containsKey(rem)) {
				map.put(rem, map.get(rem) + 1);
			} else {
				map.put(rem, 1);
			}
		}

		System.out.println(map);
		
		for (int val : arr) {
			int rem = val % k;
			// k/2 th modulus must be even freuqency
			if (2 * rem == k) {
				if (map.get(rem) % 2 != 0) {
					System.out.println("false");
					return;
				}
			// 0 rem must be even frequency
			} else if (rem == 0) {
				if (map.get(rem) % 2 != 0) {
					System.out.println("false");
					return;
				}
			} else {
				// freq of k and k-i rem must be same
				if (map.get(rem) != map.get(k - rem)) {
					System.out.println("false");
					return;
				}
			}
		}

		System.out.println("true");
	}
}

/*
Test cases:
19
6
92 75 65 48 45 35
--------------
false

10
6
92 75 65 48 45 35	
--------------
true

	
6
4
9 7 5 3
----------
true
	
	
Source: https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/	
*/