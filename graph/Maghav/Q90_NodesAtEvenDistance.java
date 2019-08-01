import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q90_NodesAtEvenDistance {
	    static int oddcounter;
	    static int evencounter;
	    //static int counter;
	    static void DFS(int vertex, boolean[]visited,ArrayList<ArrayList<Integer>>adj,
	    int steps)
	    {
	        visited[vertex]=true;
	        
	        if(steps%2==0)
	        evencounter++;
	        else
	        oddcounter++;
	        
	        for(int x:adj.get(vertex))
	        {
	             if(visited[x]==false)
	                DFS(x,visited,adj,steps+1);
	        }
	    }
		public static void main (String[] args)throws Exception {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int tc=Integer.parseInt(br.readLine());
			
			for(int t=0;t<tc;t++)
			{
			    int size=Integer.parseInt(br.readLine());
			    boolean[]visited=new boolean[size+1];
			    
			    ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
			    
			    for(int i=0;i<visited.length;i++)
			    {
			        ArrayList<Integer>a=new ArrayList<>();
			        adj.add(a);
			    }
			    
			     String[]S=br.readLine().split(" ");
			    
			    for(int i=0;i<2*(size-1);i=i+2)
			    {
			       int a=Integer.parseInt(S[i]);
			       int b=Integer.parseInt(S[i+1]);
			        
			        adj.get(a).add(b);
			        adj.get(b).add(a);
			    }
			    int ans=0;
			    for(int i=1;i<visited.length;i++)
			    {
			        oddcounter=0;
			        evencounter=0;
			        if(visited[i]==false)
			        {
			            DFS(i,visited,adj,0);
			           
			        }
			            ans=ans+(evencounter)*(evencounter-1)/2
			            +(oddcounter)*(oddcounter-1)/2;
			    }
			     System.out.println(ans);
			    
			}   
		}

}
