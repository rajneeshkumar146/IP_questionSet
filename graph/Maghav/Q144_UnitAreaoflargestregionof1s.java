import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q144_UnitAreaoflargestregionof1s {
		public static void main (String[] args) {
				Scanner sc=new Scanner(System.in);
			
			int tc=sc.nextInt();
			
			for(int t=0;t<tc;t++)
			{
			    int rows=sc.nextInt();
			    int cols=sc.nextInt();
			    
			    int[][]matrix=new int[rows][cols];
			    
			    for(int i=0;i<rows;i++)
			    {
			        for(int j=0;j<cols;j++)
			        {
			            matrix[i][j]=sc.nextInt();
			        }
		
			    }
			    boolean visited[][]=new boolean[matrix.length][matrix[0].length];
			    int ans=0;
			   for(int i=0;i<matrix.length;i++)
			   {
			       for(int j=0;j<matrix[0].length;j++)
			       {
			           if(visited[i][j]==false && matrix[i][j]==1)
			           {
			               counter=0;
			               DFS(i,j,matrix,visited);
			               ans=Math.max(ans,counter);
			           }
			        }
			    }
			   System.out.println(ans);
			    
			}
		
		}
		static int counter;
		static void DFS(int i, int j, int[][]matrix,boolean visited[][])
		{
		    visited[i][j]=true;
		    counter++;
		    
		    int[][]dirs=
				{
						{1,0},
						{1,1},
						{0,1},
						{-1,1},
						{-1,0},
						{-1,-1},
						{0,-1},
						{1,-1}
				};
			
			for(int[]x:dirs)
			{
				int newx=i+x[0];
				int newy=j+x[1];
				
				if(newx>=0 && newx<matrix.length && newy>=0 && newy<matrix[0].length 
				&&visited[newx][newy]==false && matrix[newx][newy]==1)
				{
					DFS(newx,newy,matrix,visited);
				}
			}
		}
		
	
}
