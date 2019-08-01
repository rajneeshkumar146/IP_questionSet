package pep_sns;

import java.util.HashSet;

public class contains_duplicate_iii {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		int k = 3;
		int t = 0;
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || k <= 0 || t < 0)
            return false;
        if(k >= nums.length && t == 0)
            return true;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(t == 0){
                if(set.contains(nums[i]))
                    return true;
            }else{
                for(int val : set){
                    if(Math.abs((long)val - (long)nums[i]) <= t)
                        return true;
                }
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
