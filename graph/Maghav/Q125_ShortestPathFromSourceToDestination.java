import java.util.*;
import java.lang.*;
import java.io.*;

public class Q125_ShortestPathFromSourceToDestination {
	private static class Pair
    {
        int i;
        int j;
        int steps;
        
        Pair(int x, int y,int z)
        {
            this.i=x;
            this.j=y;
            this.steps=z;
        }
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for(int t=0;t<tc;t++)
		{
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    
		    int[][]matrix=new int[m][n];
		    
		    for(int i=0;i<m;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            matrix[i][j]=sc.nextInt();
		        }
		    }
		   boolean visited[][]=new boolean[m][n];
		   LinkedList<Pair>Q=new LinkedList<>();
		   
		   int destx=sc.nextInt();
		   int desty=sc.nextInt();
		   
		   if(m>0 && n>0 && matrix[0][0]==1)
		   Q.addLast(new Pair(0,0,0));
		   
		   int[][]dirs={
		       {1,0},
		       {0,1},
		       {-1,0},
		       {0,-1}
		   };
		   int ans=0;
		   while(Q.size()>0)
		   {
		       Pair rem=Q.peek();
		       int x=rem.i;
		       int y=rem.j;
		       
		       if(visited[x][y]==false)
		       {
		           visited[x][y]=true;
		           if(x==destx && y==desty)
		           {
		               if(destx==0 && desty==0)
		               {
		                   ans=-1;
		               }
		               else
		               ans=rem.steps;
		               break;
		           }
		           
		           for(int []X:dirs)
		           {
		               int newx=x+X[0];
		               int newy=y+X[1];
		               
		               if(newx>=0 && newx<matrix.length && newy>=0 && newy<matrix[0].length
		               && matrix[newx][newy]==1)
		               {
		                   Q.addLast(new Pair(newx,newy,rem.steps+1));
		               }
		           }
		           
		       }
		       Q.pop();
		      
		   }
		    
		     if(ans==0)
		       {
		           System.out.println("-1");
		       }
		       else if(ans==-1)
		       {
		           System.out.println("0");
		       }
		       else
		       {
		           System.out.println(ans);
		       }
		}
	}

}
