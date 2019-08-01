package SnS;

public class reverse_pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,2,3,1};
		System.out.println(reversePairs(nums));
	}

	public static  int reversePairs(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = MergeSortAndCount(nums, 0, nums.length - 1);
		return res;
	}

	public static void merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		while (j <= end) {
			temp[k++] = nums[j++];
		}
		while (i <= mid) {
			temp[k++] = nums[i++];
		}
		k = 0;
		for (int x = start; x <= end; x++) {
			nums[x] = temp[k++];
		}
	}

	public static int MergeSortAndCount(int[] nums, int start, int end) {

		if (start >= end) {
			return 0;
		}
		int mid = (start + end) / 2;
		int count = MergeSortAndCount(nums, start, mid) + MergeSortAndCount(nums, mid + 1, end);

		int j = mid + 1;
		for (int i = start; i <= mid; i++) {

			while (j <= end && nums[i] > (long) nums[j] * 2) {
				j++;
			}

			count += j - mid - 1;
		}

		merge(nums, start, mid, end);
		return count;
	}

}
