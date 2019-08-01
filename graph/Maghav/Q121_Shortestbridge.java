import java.util.*;
public class Q121_Shortestbridge {
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
	    private void Changeto2(int[][]A,int i, int j,boolean[][]visited)
	    {
	        A[i][j]=2;
	        visited[i][j]=true;
	        int[][]dirs={
	            {1,0},
	            {0,1},
	            {-1,0},
	            {0,-1}
	        };
	        
	        for(int[]x:dirs)
	        {
	            int newx=i+x[0];
	            int newy=j+x[1];
	            
	            if(newx>=0 && newx<A.length && newy>=0 && newy<A[0].length && A[newx][newy]==1 && 
	             visited[newx][newy]==false)
	            {
	                Changeto2(A,newx,newy,visited);
	            }
	        }
	    }
	    public int shortestBridge(int[][] A) {
	        boolean flag=false;
	        boolean flag2=false;
	        LinkedList<Pair>Q=new LinkedList<>();
	        boolean[][]visited=new boolean[A.length][A[0].length];
	        int[][]dirs={
	            {1,0},
	            {0,1},
	            {-1,0},
	            {0,-1}
	        };
	        
	        for(int i=0;i<A.length;i++)
	        {
	            for(int j=0;j<A[0].length;j++)
	            {
	                if(flag==false && A[i][j]==1)
	                {
	                    flag=true;
	                    Changeto2(A,i,j,visited);
	                }
	                else if(flag==true && A[i][j]==1)
	                {
	                    Q.add(new Pair(i,j,0));
	                    A[i][j]=3;
	                }
	            }
	        }
	        
	        while(Q.size()>0)
	        {
	            Pair rem=Q.peek();
	            int X=rem.i;
	            int Y=rem.j;
	           if(visited[X][Y]==false) 
	          {
	               visited[X][Y]=true;
	                if(A[X][Y]==3)
	                {
	                    for(int[]x:dirs)
	                     {
	                        int newx=X+x[0];
	                        int newy=Y+x[1];

	                            if(newx>=0 && newx<A.length && newy>=0 && newy<A[0].length)
	                            {
	                                    if(A[newx][newy]==0)
	                                    {
	                                        A[newx][newy]=3;
	                                        Q.addLast(new Pair(newx,newy,rem.steps+1));
	                                    }
	                                    else if(A[newx][newy]==1)
	                                    {
	                                        A[newx][newy]=3;
	                                        Q.addLast(new Pair(newx,newy,rem.steps));
	                                    }
	                                else if(A[newx][newy]==2)
	                                {
	                                    return rem.steps;
	                                }
	                            }
	                       }   
	                 }
	           }
	            Q.pop();
	        }
	        
	        
	        return 1;
	        
	    }

}
