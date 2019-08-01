import java.util.*;
public class Q115_RottingOranges {
		   class Pair
		   {
		       int i;
		       int j;
		       int steps;
		       
		       Pair(int x, int y, int value)
		       {
		           this.i=x;
		           this.j=y;
		           this.steps=value;
		       }
		   }
		    public int orangesRotting(int[][] grid) {
		        LinkedList<Pair>Q=new LinkedList<>();
		        boolean[][]visited=new boolean[grid.length][grid[0].length];
		        
		        int count=0;
		        int ans=0;
		            for(int i=0;i<grid.length;i++)
		            {
		                for(int j=0;j<grid[0].length;j++)
		                {
		                    if(grid[i][j]==2 && visited[i][j]==false)
		                    {
		                       
		                        Q.addLast(new Pair(i,j,0));

		                    }
		                    
		                }
		            }
		        
		             
		                 int[][]dirs={
			            {1,0},
			            {0,1},
			            {0,-1},
			            {-1,0}
			        };
			        
				        while(Q.size()>0)
				        {
				            Pair rem=Q.peek();
				            
				            if(visited[rem.i][rem.j]==false)
				            {
				                visited[rem.i][rem.j]=true;
				        
		                    for(int[]x:dirs)
		                    {
		                        int newx=rem.i+x[0];
		                        int newy=rem.j+x[1];

		                        if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length
		                          && grid[newx][newy]==1)
		                        {
		                            grid[newx][newy]=2;
		                            Q.addLast(new Pair(newx,newy,rem.steps+1));
		                        }
			                    }   
			                
			            }
		            ans=Math.max(ans,rem.steps);
		            Q.pop();
		        }
		        
		        for(int i=0;i<grid.length;i++)
		        {
		            for(int j=0;j<grid[0].length;j++)
		            {
		                if(grid[i][j]==1)
		                {
		                    return -1;
		                }
		            }    
		            
		        }
		        return ans;
		        
		    }

}
