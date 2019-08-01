
public class CobinationSum4 {
	public int combinationSum4(int[] nums, int target) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] dp = new int[target+1];
	 
	    dp[0]=1;
	 
	    for(int i=0; i<=target; i++){
	       for(int num: nums){
	           if(i+num<=target){
	               dp[i+num]+=dp[i];
	           }
	       }
	    }
	 
	    return dp[target];
	}
}
