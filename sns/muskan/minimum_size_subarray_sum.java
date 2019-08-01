package pep_sns;

public class minimum_size_subarray_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(s, nums));

	}
	
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int curstart = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                len = Math.min(len, i + 1 - curstart);
                sum -= nums[curstart];
                curstart++;
            }
        }
        if(len != Integer.MAX_VALUE){
            return len;
        }else{
            return 0;
        }
        
    }

}
