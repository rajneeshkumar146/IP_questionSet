import java.util.ArrayList;
public class Q101_PossibleBipartition {
	    static boolean ans;
	    static char colour1;
	    static char colour2;
	    static void DFS(int vertex, ArrayList<ArrayList<Integer>>adj,char coloured,char[]colour)
	    {
	        if(colour[vertex]==coloured)  //Tumhaara hi colour dala hua hai
	        {
	            return;
	        }
	        if(coloured==colour1 && colour[vertex]!=colour2) // khaali hai
	        {
	            colour[vertex]=colour1;
	            coloured=colour2;
	        }
	        else if(coloured==colour2 && colour[vertex]!=colour1) //khaali hai
	        {
	            colour[vertex]=colour2;
	            coloured=colour1;
	        }
	        else  //Dusra colour dala hua hai
	        {
	            ans=false;
	            return;
	        }
	        
	        for(int x:adj.get(vertex))
	        {
	            DFS(x,adj,coloured,colour);
	        }
	        
	    }
	    public boolean possibleBipartition(int N, int[][] dislikes) {
	        
	        char colour[]=new char[N+1];
	        
	        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
	        
	        for(int i=0;i<=N;i++)
	        {
	            ArrayList<Integer>a=new ArrayList<>();
	            adj.add(a);
	        }
	        
	        for(int i=0;i<dislikes.length;i++)
	        {
	            adj.get(dislikes[i][0]).add(dislikes[i][1]);
	            adj.get(dislikes[i][1]).add(dislikes[i][0]);
	        }
	        
	        ans=true;
	        colour1='R';
	        colour2='G';
	        for(int i=1;i<=N;i++)
	        {
	            if(colour[i]!=colour1 && colour[i]!=colour2)
	            DFS(i,adj,colour1,colour);
	            
	            if(ans==false)
	            {
	                return false;
	            }
	        }
	        return ans;
	    }

}
