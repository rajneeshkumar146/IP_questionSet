import java.util.*;
public class Q117_Satisfiabilty {

	    static void DFS(int vertex, ArrayList<ArrayList<Integer>>adj, int[]colors,int counter)
	    {
	        colors[vertex]=counter;
	        
	        for(int x:adj.get(vertex))
	        {
	            if(colors[x]==0)
	            {
	                DFS(x,adj,colors,counter);
	            }
	        }
	    }
	    public boolean equationsPossible(String[] equations) {
	        
	       int[]colors=new int[26];
	        
	        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
	        for (int i = 0; i < 26; ++i)
	        {
	            ArrayList a=new ArrayList<>();
	            adj.add(a);
	        }    

	        for (String a: equations) {
	            if (a.charAt(1) == '=') {
	                int x = a.charAt(0) - 'a';      
	                int y = a.charAt(3) - 'a';
	                adj.get(x).add(y);
	                adj.get(y).add(x);
	            }
	        }
	        
	        int counter=1;
	        
	        for(int i=0;i<colors.length;i++)
	        {
	            if(colors[i]==0)
	            {
	                DFS(i,adj,colors,counter);
	                counter++;
	            }
	            
	        }
	        
	        for(String x:equations)
	        {
	            if(x.charAt(1)=='!' && colors[x.charAt(0)-'a']==colors[x.charAt(3)-'a'])
	            {
	                return false;
	            }
	        }
	       return true;
	    }
}
