import java.util.*;
public class Q135_TheMaze {

	    class Pair
	    {
	        int i;
	        int j;
	        
	        Pair(int x, int y)
	        {
	            this.i=x;
	            this.j=y;
	        }
	    }
	    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	        
	        LinkedList<Pair>Q=new LinkedList<>();
	        Q.addLast(new Pair(start[0],start[1]));
	        
	        boolean[][]visited=new boolean[maze.length][maze[0].length];
	        int m=maze.length;
	        int n=maze[0].length;
	        while(Q.size()>0)
	        {
	            Pair rem=Q.pop();
	            if(visited[rem.i][rem.j]==false)
	            {
	                visited[rem.i][rem.j]=true;
	                
	                if(rem.i==destination[0] && rem.j==destination[1])
	                {
	                    return true;
	                }
	                
	                int[][]dirs={
	                {1,0},
	                {0,1},
	                {-1,0},
	                {0,-1}
	            };
	    
	                for(int p[]:dirs)
	                {
	                    int newx=rem.i+p[0];
	                    int newy=rem.j+p[1];
	                    while(newx>=0 && newx<maze.length && newy>=0 && newy<maze[0].length
	                      && maze[newx][newy]==0)
	                    {
	                        newx=newx+p[0];
	                        newy=newy+p[1];
	                    }
	                    Q.addLast(new Pair(newx-p[0],newy-p[1]));
	                }
	                
	            }
	            
	            
	        }
	        return false;
	    }

}
