package SnS;

public class count_of_range_sums {

	public static void main(String[] args) {
		int[] arr= {1,2,3,-1,-4,-3}; 
		System.out.println(countRangeSum(arr, -2, 2));

	}

	public static int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		int res = mergeAndCount(sums, 0, nums.length, lower, upper);
		return res;
	}

	public static int mergeAndCount(long[] sums, int start, int end, int lower, int upper) {

		if (end == start) {
			return 0;
		}
		int mid = (start + end) / 2;
		int count = mergeAndCount(sums, start, mid, lower, upper) + mergeAndCount(sums, mid + 1, end, lower, upper);

		int t = mid + 1;
		int j = mid + 1;
		int k = mid + 1;
		long[] newArr = new long[end - start + 1];

		for (int i = start, r = 0; i <= mid; i++, r++) {

			while (k <= end && sums[k] - sums[i] < lower) {
				k++;
			}
			while (j <= end && sums[j] - sums[i] <= upper) {
				j++;
			}
			while (t <= end && sums[t] < sums[i]) {
				newArr[r++] = sums[t++];
			}
			newArr[r] = sums[i];
			count += j - k;
		}

		System.arraycopy(newArr, 0, sums, start, t - start);

		return count;
	}

}
