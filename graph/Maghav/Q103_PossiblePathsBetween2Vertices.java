import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q103_PossiblePathsBetween2Vertices {
	    static ArrayList<ArrayList<Integer>>adj;
	    static int ans;
	    static void DFS(int start, int end,boolean[]visited)
	    {
	        if(start==end)
	        {
	            ans++;
	            return;
	        }
	        visited[start]=true;
	        
	        for(int x:adj.get(start))
	        {
	            if(visited[x]==false)
	            DFS(x,end,visited);
	        }
	        
	        visited[start]=false;
	    }
		public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
			
			int tc=sc.nextInt();
			
			for(int t=0;t<tc;t++)
			{
			    int NumberOfNodes=sc.nextInt();
			    int rel=sc.nextInt();
			    
			    adj=new ArrayList<>();
			    boolean[]visited=new boolean[NumberOfNodes+1];
			    
			    for(int i=0;i<NumberOfNodes+1;i++)
			    {
			        ArrayList<Integer>a=new ArrayList<>();
			        adj.add(a);
			    }
			    
			    for(int i=0;i<rel;i++)
			    {
			        int source=sc.nextInt();
			        int dest=sc.nextInt();
			        
			        adj.get(source).add(dest);
			    }
			    
			    int start=sc.nextInt();
			    int end=sc.nextInt();
			    
			    ans=0;
			    DFS(start,end,visited);
			    
			    System.out.println(ans);
			}
		}

}
