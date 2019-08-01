
public class Q142_UniquePaths3 {
	    static int ans;
	    private void DFS(int i, int j, int[][]grid,int remaining)
	    {
	        if(grid[i][j]==2)
	        {
	            if(remaining==0)
	            {
	                ans++;
	            }
	            return;
	        }
	        int save=grid[i][j];
	        grid[i][j]=5; // Working similar to visited technique
	        
	             int[][]dirs={
				            {1,0},
				            {0,1},
				            {0,-1},
				            {-1,0}
				        };
	     	       
					           
			        for(int[]x:dirs)
			        {
			             int newx=i+x[0];
			             int newy=j+x[1];

			            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length
			               && (grid[newx][newy]==0 || grid[newx][newy]==2))
			            {
	                        if(save==0)
			                DFS(newx,newy,grid,remaining-1);
	                        else
	                        DFS(newx,newy,grid,remaining);
			                
			            }
				                      
				                
				     }
	        grid[i][j]=save;
	    }
	    public int uniquePathsIII(int[][] grid) {
	        ans=0;
	        int zeros=0;
	        int sx=0;
	        int sy=0;
	        for(int i=0;i<grid.length;i++)
	        {
	            for(int j=0;j<grid[0].length;j++)
	            {
	                if(grid[i][j]==0)
	                {
	                    zeros++;
	                }
	                else if(grid[i][j]==1)
	                {
	                     sx=i;
	                     sy=j;
	                }
	            }
	        }
	        
	        DFS(sx,sy,grid,zeros);
	        return ans;
	    }

}
