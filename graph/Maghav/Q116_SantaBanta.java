import java.util.*;
	import java.lang.*;
	import java.io.*;
	//import java.math.BigInteger;
public class Q116_SantaBanta {
	    static int counter;
	    static int FindPrime(int K)
	    {
	        
			int prime[] = new int[1000005];
			for(int i=2; i*i<1000005; i++)
			{
			    if(prime[i]==0)
			    {
			        for(int j=2; j*i<1000005; j++)
			            prime[i*j] =  1;
			    }
			}
			
			int p[] = new int[100005];
			int j = 1;
			for(int i=2; i<1000005; i++)
			{
			    if(prime[i]==0)
			        p[j++] = i;
			  
			}
			return p[K];
	    }
	    static void DFS(int vertex, boolean[]visited,ArrayList<ArrayList<Integer>>adj)
	    {
	        visited[vertex]=true;
	        counter++;
	        
	        for(int x:adj.get(vertex))
	        {
	            if(visited[x]==false)
	            {
	                DFS(x,visited,adj);
	            }
	        }
	    }
		public static void main (String[] args) throws Exception {
		    
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int tc=Integer.parseInt(br.readLine());
			
			for(int t=0;t<tc;t++)
			{
			    String[]S=br.readLine().split(" ");
			    int size=Integer.parseInt(S[0]);
			    int relations=Integer.parseInt(S[1]);
			    
			    boolean[]visited=new boolean[size+1];
			    ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
			    
			    for(int i=0;i<visited.length;i++)
			    {
			        ArrayList<Integer>a=new ArrayList<>();
			        adj.add(a);
			    }
			    
			    for(int i=0;i<relations;i++)
			    {
			         S=br.readLine().split(" ");
			    int a=Integer.parseInt(S[0]);
			    int b=Integer.parseInt(S[1]);
			        
			        adj.get(a).add(b);
			        adj.get(b).add(a);
			    }
			    int ans=0;
			    for(int i=1;i<visited.length;i++)
			    {
			        if(visited[i]==false)
			        {
			            counter=0;
			            DFS(i,visited,adj);
			            ans=Math.max(ans,counter);
			        }
			    }
			    if(ans==1)
			    {
			        System.out.println(-1);
			    }
			    else
			    System.out.println(FindPrime(ans));
			}
		}
}
