package OrderStatsHeapHash;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_411CheckPairsDivisibleByK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

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
			if (2 * rem == k) {
				if (map.get(rem) % 2 != 0) {
					System.out.println("false");
					return;
				}
			} else if (rem == 0) {
				if (map.get(rem) % 2 != 0) {
					System.out.println("false");
					return;
				}
			} else {
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