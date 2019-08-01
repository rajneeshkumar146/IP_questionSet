package HnH;

import java.util.Arrays;

public class Find_K_th_Smallest_Pair_Distance {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 5, 8, 3, 1 };
		int k = 5;
		smallestDistancePair(arr, k);
	}

	public static int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);

		int lo = 0;
		int hi = nums[nums.length - 1] - nums[0];
		while (lo < hi) {
			int mi = (lo + hi) / 2;
			int count = 0, left = 0;
			for (int right = 0; right < nums.length; ++right) {
				while (nums[right] - nums[left] > mi) {
					left++;
				}
				count += right - left;
			}
			// count = number of pairs with distance <= mi
			if (count >= k)
				hi = mi;
			else
				lo = mi + 1;
		}
		return lo;

	}
}
