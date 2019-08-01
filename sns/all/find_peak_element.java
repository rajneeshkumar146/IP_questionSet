package pep_sns;

public class find_peak_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 1};
		System.out.println(findPeakElement(nums));
	}

	public static int findPeakElement(int[] nums) {
		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;
		if (nums[0] > Integer.MIN_VALUE && nums[0] > nums[1])
			return 0;
		if (nums[nums.length - 1] > Integer.MIN_VALUE && nums[nums.length - 1] > nums[nums.length - 2]) {
			return nums.length - 1;
		}
		int smallest = -1;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
				smallest = i;
		}
		return smallest;
	}

}
