
public class Q99_PartitionArrayForMaxSum {
	    public int maxSumAfterPartitioning(int[] A, int K) {
	        
	        int[]dp=new int[A.length];
	        int ans=0;
	        for(int i=0;i<A.length;i++)
	        {
	            int max=0;
	            for(int k=1;k<=K && i-k+1>=0;k++)
	            {
	                max=Math.max(max,A[i-k+1]);
	                int current=0;
	             
	                if(i-k>=0)
	                {
	                    current=dp[i-k]+max*k;
	                    
	                }
	                else
	                {
	                    current=max*k;
	                    
	                }
	                dp[i]=Math.max(dp[i],current);
	                
	            }
	        }
	        
	        return dp[A.length-1];
	        
	    }
}
