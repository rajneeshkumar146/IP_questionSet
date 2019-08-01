import java.util.*;
public class Q131_StronglyConnectedComponents {
	    static Stack<Integer>S;
	    private void DFS(int vertex,ArrayList<ArrayList<Integer>> list,boolean[]visited)
	    {
	        visited[vertex]=true;
	        
	        for(int x:list.get(vertex))
	        {
	            if(visited[x]==false)
	            DFS(x,list,visited);
	        }
	        S.push(vertex);
	    }
	    private void DFS2(int vertex,ArrayList<ArrayList<Integer>> list,boolean[]visited)
	    {
	        visited[vertex]=true;
	        
	        for(int x:list.get(vertex))
	        {
	            if(visited[x]==false)
	            DFS2(x,list,visited);
	        }
	    }
	    public int kosaraju(ArrayList<ArrayList<Integer>> list, int N)
	    {
	       // System.out.print(N+"   ");
	       boolean[]visited=new boolean[N];
	       S=new Stack<>();
	       for(int i=0;i<N;i++)
	       {
	           if(visited[i]==false)
	           {
	               DFS(i,list,visited);
	           }
	       }
	       
	       ArrayList<ArrayList<Integer>> newlist=new ArrayList<>();
	       for(int i=0;i<N;i++)
	       {
	           ArrayList<Integer>a=new ArrayList<>();
	           newlist.add(a);
	       }
	       
	       for(int i=1;i<list.size();i++)
	       {
	           for(int x:list.get(i))
	           {
	               newlist.get(x).add(i);
	           }
	       }
	       int ans=0;
	       visited=new boolean[N];
	       while(S.size()>0)
	       {
	           int rem=S.pop();
	           
	           if(visited[rem]==false)
	           {
	               ans++;
	               
	               DFS2(rem,newlist,visited);
	           }
	       }
	       return ans-1;
	    }

}
