package InternQuestAS1;

import java.util.Scanner;

public class Remove_Duplicates_from_Sorted_Array_II {

	public static int removeDuplicates(int[] nums) {
		int maxsize = 2;

		if (nums.length == 0)
			return 0;

		int m = 1;

		int count = 1;

		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[i - 1]) {
				if (count < maxsize) {
					nums[m] = nums[i];
					m++;
				}
				count++;
			} else {
				count = 1;
				nums[m] = nums[i];
				m++;
			}
		}
		return m;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner scn = new Scanner(System.in);
		int[] nums = { 1, 2, 3 };
		System.out.println(removeDuplicates(nums));

	}
}
