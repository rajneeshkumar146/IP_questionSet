import java.util.*;
public class Q72_LoudAndRich {
	    private int DFS(int vertex,ArrayList<ArrayList<Integer>>adj,int[]dp,int[]quiet)
	    {
	        int ans=quiet[vertex];
	        if(dp[vertex]!=0)
	        {
	            return dp[vertex];
	        }
	        
	        for(int x:adj.get(vertex))
	        {
	            ans=Math.min(ans,DFS(x,adj,dp,quiet));
	        }
	        
	        dp[vertex]=ans;
	        return ans;
	        
	    }
	    public int[] loudAndRich(int[][] richer, int[] quiet) {
	        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
	        int[]X=new int[quiet.length];
	        
	        for(int i=0;i<quiet.length;i++)
	        {
	            ArrayList<Integer>a=new ArrayList<>();
	            adj.add(a);
	        }
	        
	        for(int i=0;i<quiet.length;i++)
	        {
	            X[quiet[i]]=i;
	        }
	        
	        int[]ans=new int[quiet.length];
	        
	        for(int i=0;i<richer.length;i++)
	        {
	            int x=richer[i][0];
	            int y=richer[i][1];
	            
	            adj.get(y).add(x);
	        }
	        int[]dp=new int[quiet.length];
	        for(int i=0;i<quiet.length;i++)
	        {
	            if(dp[i]==0)
	            ans[i]=X[Math.min(quiet[i],DFS(i,adj,dp,quiet))];
	            else
	                ans[i]=X[dp[i]];
	        }
	        
	        return ans;
	    }

}
