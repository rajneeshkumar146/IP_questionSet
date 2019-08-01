import java.util.*;
public class Q136_Maze2 {
	
		class Pair implements Comparable<Pair>
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
		    
		        public int compareTo(Pair x)
		        {
		            return this.steps-x.steps;
		        }
		    }
		  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		             
		        PriorityQueue<Pair>Q=new PriorityQueue<>();
		        Q.add(new Pair(start[0],start[1],0));
		        
		        boolean[][]visited=new boolean[maze.length][maze[0].length];
		        
		        while(Q.size()>0)
		        {
		            Pair rem=Q.remove();
		            if(visited[rem.i][rem.j]==false)
		            {
		                visited[rem.i][rem.j]=true;
		                
		                if(rem.i==destination[0] && rem.j==destination[1])
		                {
		                    return rem.steps;
		                }
		                
		                int[][]dirs={
		                {1,0},
		                {0,1},
		                {-1,0},
		                {0,-1}
		            };
		    
		                for(int p[]:dirs)
		                {
		                    int steps=0;
		                    int newx=rem.i;
		                    int newy=rem.j;
		                    while(newx>=0 && newx<maze.length && newy>=0 && newy<maze[0].length
		                      && maze[newx][newy]==0)
		                    {
		                        steps++;
		                        newx=newx+p[0];
		                        newy=newy+p[1];
		                    }
		                    Q.add(new Pair(newx-p[0],newy-p[1],rem.steps+steps-1));
		                }
		                
		            }
		            
		            
		        }
		        return -1;
		    }

}
