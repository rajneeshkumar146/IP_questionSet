package InternQuestDP;

import java.util.Scanner;

public class Range_Sum_Query_Immutable {
    private static int[] sum;

public static  void NumArray(int[] nums) {
    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        sum[i + 1] = sum[i] + nums[i];
    }
}

public static int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int []nums = {-2, 0, 3, -5, 2, -1};
		NumArray(nums);

				System.out.println(sumRange(0, 2)); 
				System.out.println(sumRange(2, 5)); 
				System.out.println(sumRange(0, 5)); 

	}
}


