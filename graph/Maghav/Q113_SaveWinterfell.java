import java.util.*;
import java.lang.*;
import java.io.*;

public class Q113_SaveWinterfell {
    static int DFS(int vertex,
    boolean[]visited, int[][]distance)
    {
        visited[vertex]=true;
        int ans=0;
        for(int i=0;i<distance.length;i++)
        {
            if(visited[i]==false && distance[vertex][i]>0)
            {
                ans=Math.max(ans,distance[vertex][i]+DFS(i,visited,distance));
            }
        }
        return ans;
    }
	public static void main (String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++)
		{
		    int size=Integer.parseInt(br.readLine());
		    boolean[]visited=new boolean[size+1];
		    int[][]dist=new int[size+1][size+1];
		    
		  //  ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		  //  for(int k=0;k<=size;k++)
		  //  {
		  //      ArrayList<Integer>x=new ArrayList<>();
		  //      adj.add(x);
		  //  }
		    
		    for(int i=0;i<size-1;i++)
		    {
		        String[]S=br.readLine().split(" ");
		        int a=Integer.parseInt(S[0]);
		        int b=Integer.parseInt(S[1]);
		        int c=Integer.parseInt(S[2]);
		        
		      //  adj.get(a).add(b);
		      //  adj.get(b).add(a);
		        dist[a][b]=c;
		        
		    }
		    int ans=0;
		    for(int i=1;i<=size;i++)
		    {
		         visited=new boolean[size+1];
		         int maxdistance=DFS(i,visited,dist);
		         ans=Math.max(ans,maxdistance);
		    }
		    System.out.println(ans);
		}
	}
}
