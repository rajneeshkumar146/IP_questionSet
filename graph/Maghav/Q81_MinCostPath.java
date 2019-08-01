import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q81_MinCostPath {
	    
	    static class Pair implements Comparable<Pair>
	    {
	        int i;
	        int j;
	        int value;
	        
	        Pair(int x, int y, int cost)
	        {
	            this.i=x;
	            this.j=y;
	            this.value=cost;
	        }
	        
	        public int compareTo(Pair x)
	        {
	            return this.value-x.value;
	        }
	    }

		public static void main (String[] args) throws Exception {
		   
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		   
		   int tc=Integer.parseInt(br.readLine());
		   
		   for(int t=0;t<tc;t++)
		   {
		       int size=Integer.parseInt(br.readLine());
		       
		       String[]S=br.readLine().split(" ");
		       int[][]matrix=new int[size][size];
		       
		       boolean[][]visited=new boolean[size][size];
		       
		       int k=0;
		       for(int i=0;i<matrix.length;i++)
		       {
		           for(int j=0;j<matrix[0].length;j++)
		           {
		               matrix[i][j]=Integer.parseInt(S[k++]);
		
		           }
		       }
		       int ans=0;
		       PriorityQueue<Pair>PQ=new PriorityQueue<>();
		       PQ.add(new Pair(0,0,matrix[0][0]));
		       
		           int[][]dirs={
				            {1,0},
				            {0,1},
				            {0,-1},
				            {-1,0}
				        };

		       
		       while(PQ.size()>0)
		       {
		           Pair rem=PQ.remove();
		           if(visited[rem.i][rem.j]==false)
		           {
		               visited[rem.i][rem.j]=true;
		               
		               if(rem.i==matrix.length-1 && rem.j==matrix[0].length-1)
		               {
		                   ans=rem.value;
		                   break;
		               }
		               
		               for(int[]x:dirs)
			           {
			              int newx=rem.i+x[0];
			              int newy=rem.j+x[1];

			              if(newx>=0 && newx<matrix.length && newy>=0 
			              && newy<matrix[0].length
			              && visited[newx][newy]==false)
			                {
			                  PQ.add(new Pair(newx,newy,rem.value+matrix[newx][newy]));
			                }
			            } 
		               
		               
		           }
		           
		       }
		       System.out.println(ans);
		   }
		
		}

}
