import java.util.*;
public class Q69_MaximumConsecutiveSequence {
	    public int longestConsecutive(int[] nums) {
	        
	        int[]ans=new int[nums.length];
	        
	        HashMap<Integer,Boolean>hm=new HashMap<>();
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            hm.put(nums[i],true);
	        }
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            if(hm.containsKey(nums[i]-1))
	            {
	                ans[i]=-1;
	            }
	        }
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<nums.length;i++)
	        {
	            if(ans[i]!=-1)
	            {
	                int l=1;
	                int count=1;
	                while(hm.containsKey(nums[i]+l))
	                {
	                    count++;
	                    l++;
	                }
	                ans[i]=count;
	            }
	            max=Math.max(max,ans[i]);
	        }
	        if(max!=Integer.MIN_VALUE)
	        return max;
	        else
	            return 0;
	        
	    }
}
