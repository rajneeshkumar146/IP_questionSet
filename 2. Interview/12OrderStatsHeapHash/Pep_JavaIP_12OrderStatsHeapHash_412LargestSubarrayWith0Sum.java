package OrderStatsHeapHash;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_412LargestSubarrayWith0Sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max_length = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum) == false) {
				map.put(sum, i);
			} else {
				int diff = i - map.get(sum);
				if (diff > max_length) {
					max_length = diff;
				}
			}
		}
		System.out.println(max_length);
	}

}



/*
Test cases:
8
15 -2 2 -8 1 7 10 23
------------------
5

6
92 75 65 48 45 35	
--------------
0

	
5
1 0 0 0 3
----------
3
	
	
Source: https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
*/
