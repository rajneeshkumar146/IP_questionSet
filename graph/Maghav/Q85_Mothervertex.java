import java.util.*;
public class Q85_Mothervertex {

	    static Stack<Integer>st;
	    static int counter;
	    static int findMother(ArrayList<ArrayList<Integer>> list, int n)
	    {
	        st=new Stack<>();
	        
	        boolean[]visited=new boolean[n+1];

	        for(int i=0;i<visited.length;i++)
	        {
	            if(list.get(i).size()>0 && visited[i]==false)
	            DFS(0,visited,list);
	            
	        }
	       
	        
	        int check=st.pop();
	        counter=0;
	        visited=new boolean[n];
	        DFS(check,visited,list);
	        System.out.println(check+" "+counter);
	        
	        if(counter==n)
	        {
	            return check;
	        }
	         
	        return -1;
	    }
	    private static void DFS(int vertex, boolean[]visited, ArrayList<ArrayList<Integer>>adj)
	    {
	        visited[vertex]=true;
	        counter++;
	        for(int x:adj.get(vertex))
	        {
	            if(visited[x]==false)
	            {
	                DFS(x,visited,adj);
	            }
	        }
	        st.push(vertex);
	    }
	    

}
