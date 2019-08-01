import java.util.*;
public class Q146_WallsAndGates {
	    class Pair
	    {
	        int i;
	        int j;
	        int distance;
	        
	        Pair(int a, int b, int c)
	        {
	            this.i=a;
	            this.j=b;
	            this.distance=c;
	        }
	    }
	    public void wallsAndGates(int[][] rooms) {
	        
	        LinkedList<Pair>Q=new LinkedList<>();
	        if(rooms.length >0)
	        { 
	            boolean[][]visited=new boolean[rooms.length][rooms[0].length];
	            for(int i=0;i<rooms.length;i++)
	            {
	                for(int j=0;j<rooms[0].length;j++)
	                {
	                    if(rooms[i][j]==0)
	                    {
	                        Q.addLast(new Pair(i,j,0));

	                    }
	                }
	            }

	            int[][]dirs={
	                {1,0},
	                {0,1},
	                {-1,0},
	                {0,-1}
	            };
	            while(Q.size()>0)
	            {
	                Pair rem=Q.removeFirst();

	                if(visited[rem.i][rem.j]==false)
	                {
	                    visited[rem.i][rem.j]=true;
	                    if(rooms[rem.i][rem.j]>=Integer.MAX_VALUE)
	                    {
	                        rooms[rem.i][rem.j]=rem.distance;
	                    }

	                    for(int[]x:dirs)
	                    {
	                        int newx=rem.i+x[0];
	                        int newy=rem.j+x[1];

	                        if(newx>=0 && newx<rooms.length && newy>=0 && newy<rooms[0].length &&                          rooms[newx][newy]!=-1)
	                        {
	                            Q.addLast(new Pair(newx, newy, rem.distance+1));
	                        }
	                    }

	                }
	            }
	        }
	    }

}
