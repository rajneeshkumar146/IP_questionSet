package InternshipQuestionAs1;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class Valid_Triangle_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(triangleNumber(new int[] { 2, 2, 3, 4 }));
	}

	public static int triangleNumber(int[] nums) {

		int n = nums.length;
		if (n < 3)
			return 0;

		int ans = 0;

		Arrays.sort(nums);

		for (int i = n - 1; i >= 2; i--) {

			int j = i - 1;
			int k = 0;

			while (k < j) {

				if (nums[k] + nums[j] > nums[i]) {
					ans += (j - k + 1) - 1;
					j--;
				} else
					k++;
			}
		}

		return ans;

	}
}
//Arrays.sort(nums, new Comparator<Integer>() {
//@Override
//public int compare(Integer o1, Integer o2) {
//	if (o1 > o2) {
//		return 1;
//	} else if (o1 == o2) {
//		return 0;
//	} else {
//		return -1;
//	}
//}
//
//});
