
	import java.util.*;
	import java.lang.*;
	import java.io.*;

public class Q139_TransitiveClosure_BFS {
	    static int[][]ans;
	    static ArrayList<ArrayList<Integer>>adj;
		public static void main (String[] args) {
		  Scanner sc=new Scanner(System.in);
		  
		  int testcases=sc.nextInt();
		  
		  for(int t=0;t<testcases;t++)
		  {
		      int size=sc.nextInt();
		      
		      adj=new ArrayList<>();
		      for(int i=0;i<size;i++)
		      {
		          ArrayList<Integer>a=new ArrayList<>();
		          adj.add(a);
		      }
		      
		      for(int i=0;i<size;i++)
		      {
		          for(int j=0;j<size;j++)
		          {
		              int k=sc.nextInt();
		              
		              if(k==1)
		              {
		                  adj.get(i).add(j);
		              }
		          }
		      }
		      ans=new int[size][size];
		      
		      for(int i=0;i<size;i++)
		      {
		            DFS(i,i);
		         
		      }
		      
		      for(int i=0;i<ans.length;i++)
		      {
		          for(int j=0;j<ans[0].length;j++)
		          {
		              System.out.print(ans[i][j]+" ");
		          }
		      }
		      System.out.println();
		  }
		  
		}
		static void DFS(int i,int j)
		{
		    ans[i][j]=1;
	    	    for(int k:adj.get(j))
	    	    {
	        	    if(ans[i][k]==0)
	        	   {
	        	      DFS(i,k);
	        	   }
	    	    } 
		}
}
