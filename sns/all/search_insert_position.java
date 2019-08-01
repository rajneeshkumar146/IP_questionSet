package SnS;

public class search_insert_position {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {5, 8, 9, 15};
		System.out.println(searchInsert(nums, 10));
	}

	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low;
	}
}
