package OrderStatsHeapHash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_415LongestSubarrayWithContiguousElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		// This is when we have all distinct elements
		// Here we assign same group number to all the elements of consecutive group
		// Then we check maximum length of all same group number elements.
		// System.out.println(lengthOfLargestSa(arr));
		// Here, we have duplicate items.
		solve(arr);

	}

	private static void solve(int[] arr) {

		int max_len = 1;
		for (int i = 0; i < arr.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(arr[i]);
			int max = arr[i];
			int min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				// If current element is already in hash set, then
				// this subarray cannot contain contiguous elements
				if (set.contains(arr[j]))
					break;

				// Else add current element to hash set and update
				// min, max if required.
				int oldmin = min;
				set.add(arr[j]);
				min = Math.min(min, arr[j]);
				//here we have to print largest set of integers that could be arranged to form continuous sequence.
				//either of the two things shd get updated, either max or min.
				max = Math.max(max, arr[j]);

				// We have already checked for duplicates, now check
				// for other property and update max_len if needed
				if (max - min == j - i)
					max_len = Math.max(max_len, max - min + 1);
				else {
					//if nothing of the two gets updated, we need to break.
					break;
				}
			}
		}

		System.out.println(max_len);
	}

	public static int lengthOfLargestSa(int[] arr) {

		int[] tempArr = Arrays.copyOf(arr, arr.length);

		Arrays.sort(tempArr);
		int count = 0;

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int val : tempArr) {
			if (hm.containsKey(val - 1)) {
				hm.put(val, count);
			} else {
				count++;
				hm.put(val, count);
			}
		}

		// System.out.println(hm);

		int grpNo = hm.get(arr[0]);
		count = 0;
		int maxlen = 0;
		for (int val : arr) {
			if (hm.get(val) == grpNo) {
				count++;
			} else {

				grpNo = hm.get(val);

				if (count > maxlen) {
					maxlen = count;
				}
				count = 1;
			}

		}
		if (count > maxlen) {
			maxlen = count;
		}

		return maxlen;

	}
}


/*Test cases:
	4
	12 14 13 12
	---------
	3
	
	6
	10 11 12 9 8 13
	--------------
	6
	
	11
	10 11 12 12 13 14 15 16 11 17 10
	-----------
	8
	
	
source: https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
*/