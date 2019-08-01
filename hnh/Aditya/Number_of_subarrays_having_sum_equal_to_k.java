package may28;

import java.util.HashMap;

public class Number_of_subarrays_having_sum_equal_to_k {

	public int subarraySum(int[] nums, int k) {

		HashMap<Integer, Integer> map=new HashMap<>();
		
		
		int sumsf=0;
		int count=0;
		
		for(int i=0;i<nums.length;i++){
			sumsf+=nums[i];
			
			if(sumsf==k){
				count++;
			}
			
			if(map.containsKey(sumsf-k)){
				count+=map.get(sumsf-k);
			}
			
			
			map.put(sumsf, map.getOrDefault(sumsf, 0)+1);
			
		}
		
		return count;
		
	}
}
