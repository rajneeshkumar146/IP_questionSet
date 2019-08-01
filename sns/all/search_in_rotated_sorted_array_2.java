package SnS;

public class search_in_rotated_sorted_array_2 {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 1, 2, 3 };
		System.out.println(search(arr, 11));
	}

	public static int search(int[] nums, int target) {
		int high1 = nums.length - 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == target) {
				return i;
			} else if (nums[i] > nums[i + 1]) {
				high1 = i;
				break;
			}
		}

		int res1 = binarySearch(nums, 0, high1, target);
		if (res1 != -1) {
			return res1;
		}

		return binarySearch(nums, high1 + 1, nums.length - 1, target);

	}

	public static int binarySearch(int[] arr, int low, int high, int target) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

}
