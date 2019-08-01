
	import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q64_KnightWalk {
	    private static class Pair
	    {
	        int i;
	        int j;
	        int steps;
	        
	        Pair(int a, int b, int c)
	        {
	            this.i=a;
	            this.j=b;
	            this.steps=c;
	        }
	    }
		public static void main (String[] args)throws Exception{
		    
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    
		    int tc=Integer.parseInt(br.readLine());
		    
		    for(int t=0;t<tc;t++)
		    {
		        String[]S=br.readLine().split(" ");
		        int n=Integer.parseInt(S[0]);
		        int m=Integer.parseInt(S[1]);
		    
	    	    S=br.readLine().split(" ");
	    	    int x1=Integer.parseInt(S[0]);
	    	    int y1=Integer.parseInt(S[1]);
	    	    int x2=Integer.parseInt(S[2]);
	    	    int y2=Integer.parseInt(S[3]);
	    	    
	    	    int X[] = {2, 2, -2, -2, 1, 1, -1, -1};
	            int Y[] = {-1, 1, 1, -1, 2, -2, 2, -2};
	            
	            int ans=-1;
	            LinkedList<Pair>Q=new LinkedList<>();
	            if(x1<0 ||x1>n ||y1<0 ||y1>m)
	            {
	                ans=-1;
	            }
	            else
	            Q.addLast(new Pair(x1-1,y1-1,0));
	            
	            boolean[][]visited=new boolean[n][m];
	            
	        
	            while(Q.size()>0)
	            {
	                Pair rem=Q.pop();
	        
	                   if(visited[rem.i][rem.j]==false)
	                   {
	                       visited[rem.i][rem.j]=true;
	                       if(rem.i==x2-1 && rem.j==y2-1)
	                       {
	                           ans=rem.steps;
	                           break;
	                       }
	                       
	                      for(int j=0;j<X.length;j++)
	    		           {
	    		               int newx=rem.i+X[j];
	    		               int newy=rem.j+Y[j];
	    		               
	    		               if(newx>=0 && newx<n && newy>=0 
	    		               && newy<m && visited[newx][newy]==false)
	    		               {
	    		                   Q.addLast(new Pair(newx,newy,rem.steps+1));
	    		               }
	    		           }
	                   }
	                
	            }
		        System.out.println(ans);
		    }
		   
		}

}
