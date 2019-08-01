
public class Q137_TheMaze3 {
        
		class Pair implements Comparable<Pair>
		    {
		        int i;
		        int j;
		        int steps;
		        String path;
		    
		        Pair(int x, int y,int z,String a)
		        {
		            this.i=x;
		            this.j=y;
		            this.steps=z;
		            this.path=a;
		        }
		    
		        public int compareTo(Pair x)
		        {
		            return this.steps-x.steps;
		        }
		    }
		 public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		             
		       PriorityQueue<Pair>Q=new PriorityQueue<>();
		        Q.add(new Pair(ball[0],ball[1],0,""));
		        
		        boolean[][]visited=new boolean[maze.length][maze[0].length];
		        String ans=new String("");
		        int val=Integer.MAX_VALUE;
		        
		        while(Q.size()>0)
		        {
		            Pair rem=Q.remove();
		            if(visited[rem.i][rem.j]==false)
		            {
		                visited[rem.i][rem.j]=true;
		                
		                int[][]dirs={
		                {1,0},
		                {0,1},
		                {-1,0},
		                {0,-1}
		            };
		                char[]c={'d','r','u','l'};
		                int count=0;
		                for(int p[]:dirs)
		                {
		                    int steps=0;
		                    int newx=rem.i;
		                    int newy=rem.j;
		                    String A=rem.path;
		                    while(newx>=0 && newx<maze.length && newy>=0 && newy<maze[0].length
		                      && maze[newx][newy]==0)
		                    {
		                        steps++;
		                        newx=newx+p[0];
		                        newy=newy+p[1]; 
		                        if(newx==hole[0] && newy==hole[1])
		                        {
		                            if(rem.steps+steps<val)
		                            {
		                                val=rem.steps+steps;
		                                ans=rem.path+c[count];
		                            }
		                            else if(val==rem.steps+steps)
		                            {
		                                if(ans.compareTo(rem.path+c[count])>1)
		                                {
		                                    ans=rem.path+c[count];
		                                }
		                            }
		                        }
		                    }
		                    
		                    if(steps>1)
		                    {
		                         A=A+c[count];
		                    }
		                    count++;
		                    Q.add(new Pair(newx-p[0],newy-p[1],rem.steps+steps-1,A));
		                }
		                
		            }
		            
		            
		        }
		   
		       if(!ans.equals(""))
		       return ans;
		       else
		       return "impossible";
		    }

}
