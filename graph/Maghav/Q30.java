import java.util.*;
	import java.lang.*;
	import java.io.*;

public class Q30 {
	    private static class Pair
	    {
	        Integer i;
	        Integer j;
	        Integer srci;
	        Integer srcj;
	        
	        Pair(Integer x, Integer y,Integer a, Integer b)
	        {
	            this.i=x;
	            this.j=y;
	            this.srci=a;
	            this.srcj=b;
	        }
	    }
		public static void main (String[] args) throws Exception {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			Integer tc=Integer.parseInt(br.readLine());
			
			for(Integer t=0;t<tc;t++)
			{
			    String[]S=br.readLine().split(" ");
			    Integer n=Integer.parseInt(S[0]);
			    Integer m=Integer.parseInt(S[1]);
			    
			    Integer [][]matrix=new Integer [n][m];
			    S=br.readLine().split(" ");
			    Integer k=0;
			   
			    for(Integer i=0;i<n;i++)
			    {
			        for(Integer j=0;j<m;j++)
			        {
			            matrix[i][j]=Integer.parseInt(S[k++]);
			        }
			    }
			    Integer [][]ans=new Integer [n][m];
			    LinkedList<Pair>Q=new LinkedList<>();
	        
			    
			    for(Integer i=0;i<n;i++)
			    {
			        for(Integer j=0;j<m;j++)
			        {
			            ans[i][j]=0;
			            if(matrix[i][j]==1)
			            {
			                Q.addLast(new Pair(i,j,i,j));
		
			            }      
			        }
			    }
	        
	        Boolean[][]visited=new Boolean[matrix.length][matrix[0].length];
	        
	        for(Integer i=0;i<n;i++)
			    {
			        for(Integer j=0;j<m;j++)
			        {
			           visited[i][j]=false;
			        }
			    }
	        
	        while(Q.size()>0)
	        {
	            Pair rem=Q.pop();
	            
	            if(visited[rem.i][rem.j]==false)
	            {
	                visited[rem.i][rem.j]=true;
	                if(matrix[rem.i][rem.j]==0)
	                {
	                    Integer p=Math.abs(rem.srci-rem.i)+Math.abs(rem.srcj-rem.j);
	                    ans[rem.i][rem.j]=p;
	                   
	                }
	                  Integer [][]dirs={
	                      {1,0},
	                      {0,1},
	                      {-1,0},
	                      {0,-1}
	                  };
	                  
	                  for(Integer []x:dirs)
	                  {
	                      Integer newx=rem.i+x[0];
	                      Integer newy=rem.j+x[1];
	                      
	                      if(newx>=0 && newx<matrix.length && newy>=0 && newy<matrix[0].length
	                      && visited[newx][newy]==false)
	                      {
	                          Q.addLast(new Pair(newx,newy,rem.srci,rem.srcj));
	                      }
	                  }
	                  
	            }
	        }
			    
			    for(Integer i=0;i<n;i++)
			    {
			        for(Integer j=0;j<m;j++)
			        {
			            System.out.print(ans[i][j]+" ");
			        }
			    }
			    
			    
			    System.out.println();
			}
		}
}
