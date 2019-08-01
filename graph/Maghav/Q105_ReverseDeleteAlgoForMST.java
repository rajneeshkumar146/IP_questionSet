import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q105_ReverseDeleteAlgoForMST{

	    static class pair implements Comparable<pair>
	    {
	        int x;
	        int y;
	        int distance;
	        
	        pair(int a, int b, int c)
	        {
	            this.x=a;
	            this.y=b;
	            this.distance=c;
	        }
	        
	        public int compareTo(pair p)
	        {
	            return this.distance-p.distance;
	        }
	    }
	    
	    private static int DFS(int vertex,ArrayList<ArrayList<Integer>>adj,boolean[]visited)
	    {
	        int count=1;
	        visited[vertex]=true;
	        
	        for(int x:adj.get(vertex))
	        {
	            if(visited[x]==false)
	            count=count+DFS(x,adj,visited);
	        }
	        return count;
	    }
		public static void main (String[] args) throws Exception {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int tc=Integer.parseInt(br.readLine());
			
			for(int t=0;t<tc;t++)
			{
			    String[]S=br.readLine().split(" ");
			    int size=Integer.parseInt(S[0]);
			    int total=Integer.parseInt(S[1]);
			    boolean[]visited=new boolean[size];
			    
			    ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
			    
			    for(int i=0;i<size;i++)
			    {
			        ArrayList<Integer>a=new ArrayList<>();
			        adj.add(a);
			    }
			    
			    PriorityQueue<pair>PQ=new PriorityQueue<>(Collections.reverseOrder());
			    S=br.readLine().split(" ");
			    for(int l=0;l<3*total;l=l+3)
			    {
			        int r=Integer.parseInt(S[l]);
			        int s=Integer.parseInt(S[l+1]);
			        int u=Integer.parseInt(S[l+2]);
			        
			        PQ.add(new pair(r,s,u));
			        adj.get(r).add(s);
			        adj.get(s).add(r);
			    }
			    int weight=0;
			    while(PQ.size()>0)
			    {
			        pair rem=PQ.remove();
			        
			        adj.get(rem.x).remove(rem.y);  //Error in this 
			        adj.get(rem.y).remove(rem.x);
			        
			        if(DFS(0,adj,visited)!=size)
			        {
			            adj.get(rem.x).add(rem.y);
			            adj.get(rem.y).add(rem.x);
	                    weight=weight+rem.distance;
			        }
			        
			    }
			    System.out.println(weight);
			}
		}

}
