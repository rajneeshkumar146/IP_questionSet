package OrderStatsHeapHash;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_413CountDistinctElemetnsInWindowOfSizeK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		/**
		 * Key: element
		 * Value : Frequency of element
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		// Build first window of k size
		for (int i = 0; i < k; i++) {
			if (map.containsKey(arr[i]) == false) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		System.out.print(map.size() + " ");
		int lo = 0;
		int hi = k;
		// iterate over arrays in k sized windows 
		while (hi < arr.length) {
			// new distinct element
			if (map.containsKey(arr[hi]) == false) {
				map.put(arr[hi], 1);
			// update frequency
			} else {
				map.put(arr[hi], map.get(arr[hi]) + 1);
			}
			if (map.get(arr[lo]) > 1) {
				map.put(arr[lo], map.get(arr[lo]) - 1);
			// remove last window element if its frequency was 1
			} else {
				map.remove(arr[lo]);
			}
			lo++;
			// gives count of distinct element
			System.out.print(map.size() + " ");
			hi++;

		}
	}

}

/*
Test cases:
4
7
1 2 1 3 4  2 3 
---------------
3 4 4 3 

4
8
92 92 75 65 75 48 45 35	
--------------
true

	
2
4
9 7 7 4
----------
2 1 2
	
	
Source: https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
*/


