import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q104_PrintAdjacencyList {
		public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			int tc=sc.nextInt();
			for(int t=0;t<tc;t++)
			{
			    int size=sc.nextInt();
			    
			    ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
			    
			    for(int i=0;i<size;i++)
			    {
			        ArrayList<Integer>a=new ArrayList<>();
			        adj.add(a);
			    }
			    
			    int queries=sc.nextInt();
			    
			    for(int k=0;k<queries;k++)
			    {
			        int x=sc.nextInt();
			        int b=sc.nextInt();
			        
			        adj.get(x).add(b);
			        adj.get(b).add(x);
			    }
			    
			    for(int j=0;j<size;j++)
			    {
			        System.out.print(j);
			        for(int p:adj.get(j))
			        {
			            System.out.print("-> "+p);
			        }
			        System.out.println();
			    }
			}
		}

}
