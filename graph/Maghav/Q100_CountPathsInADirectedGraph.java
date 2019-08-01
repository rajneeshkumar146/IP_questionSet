import java.util.*;
public class Q100_CountPathsInADirectedGraph {
	    private int DFS(int start, int end, ArrayList<Integer>[]adj,int[]dp,
	    boolean[]visited)
	    {
	        int ans=0;
	        if(start==end)
	        {
	            return 1;
	        }
	        visited[start]=true;
	        
	        
	        for(int i=0;i<adj[start].size();i++)
	        {
	            if(visited[adj[start].get(i)]==false)
	            ans=ans+DFS(adj[start].get(i),end,adj,dp,visited);
	        }
	        
	        visited[start]=false;
	        
	        return ans;
	        
	    }
	    public int pathCount (Graph g, int src, int des){
	        //Write your code here, return the total number of paths
	        ArrayList<Integer>[]adj=g.edges;
	        int[]dp=new int[g.v];
	        boolean[]visited=new boolean[g.v];
	        
	        int ans=DFS(src,des,adj,dp,visited);
	        
	        return ans;
	    }

}
