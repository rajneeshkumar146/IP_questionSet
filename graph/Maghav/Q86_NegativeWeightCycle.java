
	import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q86_NegativeWeightCycle {
	    static class Edge
	    {
	        int i;
	        int j;
	        int weight;
	        
	        Edge(int a, int b, int c)
	        {
	            this.i=a;
	            this.j=b;
	            this.weight=c;
	        }
	    }
		public static void main (String[] args)throws Exception {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int tc=Integer.parseInt(br.readLine());
			
			for(int t=0;t<tc;t++)
			{
			    String[]S=br.readLine().split(" ");
			    int V=Integer.parseInt(S[0]);
			    int E=Integer.parseInt(S[1]);
			    int[]distance=new int[V+1];
			    
			    int source=0;
			    
			    for(int i=0;i<distance.length;i++)
			    {
			        distance[i]=Integer.MAX_VALUE;
			    }
			    distance[source]=0;
			    
			    ArrayList<Edge>AllEdges=new ArrayList<>();
			    
			    S=br.readLine().split(" ");
			    for(int i=0;i<3*E;i=i+3)
			    {
			        int a=Integer.parseInt(S[i]);
			        int b=Integer.parseInt(S[i+1]);
			        int c=Integer.parseInt(S[i+2]);
			        AllEdges.add(new Edge(a,b,c));
			    }
			    
			    for(int i=0;i<V-1;i++)
			    {
			        for(Edge e:AllEdges)
			        {
			            if(distance[e.i]!=Integer.MAX_VALUE && distance[e.j]>distance[e.i]+e.weight)
			            {
			               distance[e.j]=distance[e.i]+e.weight;
			            }
			        }
			    }
			    int ans=0;
			    for(Edge e:AllEdges)
			        {
			            if(distance[e.i]!=Integer.MAX_VALUE && distance[e.j]>distance[e.i]+e.weight)
			            {
			                 ans=1;
			            }
			        }
			      System.out.println(ans);
			}
		}
}
