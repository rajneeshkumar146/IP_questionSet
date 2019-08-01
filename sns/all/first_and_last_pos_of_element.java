package pep_sns;

public class first_and_last_pos_of_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] result = searchRange(nums, target);
		for (int val : result)
			System.out.print(val + " ");

	}

	public static int[] searchRange(int[] nums, int target) {
		int[] indices = { -1, -1 };
		if (nums.length == 0)
			return indices;
		// for left index
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target || nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		indices[0] = left != nums.length && nums[left] == target ? left : -1;
		// for right index
		left = 0;
		right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		indices[1] = left - 1 >= 0 && nums[left - 1] == target ? left - 1 : -1;
		return indices;
	}

}
