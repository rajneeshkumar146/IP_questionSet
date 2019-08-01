package pep_sns;

public class find_min_in_rotated_sorted_arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,5,1,2};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums[nums.length - 1] > nums[0] || nums.length == 1){
            return nums[0];
        }else{
            int low = 0;
            int high = nums.length - 1;
            while(low <= high){
                int mid = (low + high)/2;
                if(nums[mid] > nums[mid + 1]){ // 3 > 2
                    return nums[mid + 1];
                }
                if(nums[mid - 1] > nums[mid]){ // 7 > 2
                    return nums[mid];
                }
                if(nums[mid] > nums[low]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return -1;
        }
    }

}
