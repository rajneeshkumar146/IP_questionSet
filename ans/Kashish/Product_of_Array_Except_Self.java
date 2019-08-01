package InternQuestAS1;

import java.util.Scanner;

public class Product_of_Array_Except_Self {
	public static int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = nums[0];
		right[nums.length - 1] = nums[nums.length - 1];
		int product[] = new int[nums.length];
		for (int i = 1; i < left.length; i++) {
			left[i] = left[i - 1] * nums[i];
		}
		
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i];
		}
		
		for (int i = 0; i < product.length; i++) {
			if (i - 1 < 0) {
				product[i] = right[i + 1];
			} else if (i + 1 >= nums.length) {
				product[i] = left[i - 1];
			} else {
				product[i] = left[i - 1] *right[i + 1];

			}
		}

		return product;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int Input[] = {1,2,3,4};
		int ans[]=productExceptSelf(Input);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

}
