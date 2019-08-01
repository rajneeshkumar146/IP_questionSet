package pep_sns;

import java.util.Arrays;

public class maximum_gap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,6,9,1};
		System.out.println(maximumGap(nums));
	}
	
	public static int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int max = -1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] - nums[i] > max){
                max = nums[i+1] - nums[i];
            }
        }
        return max;
    }

}
