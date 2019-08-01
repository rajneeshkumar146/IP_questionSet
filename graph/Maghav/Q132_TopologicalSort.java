import java.util.*;
public class Q132_TopologicalSort {
	    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
	    {
	           int[]indegree=new int[N];
	           LinkedList<Integer>Q=new LinkedList<>();
	            int[]A=new int[N];
	           int counter=A.length-1;
	           
	           for(int i=0;i<list.size();i++)
	           {
	               for(int x:list.get(i))
	               {
	                   indegree[x]++;
	               }
	           }
	           
	           for(int i=0;i<N;i++)
	           {
	               if(indegree[i]==0)
	               {
	                   Q.addLast(i);
	                   
	               }
	           }
	           
	           while(Q.size()>0)
	           {
	                   int rem=Q.pop();
	                   A[counter--]=rem;
	                   for(int x:list.get(rem))
	                   {
	                       indegree[x]--;
	                      if(indegree[x]==0)
	                       Q.addLast(x);
	                   }
	              
	           }
	           //System.out.print("!!");
	           return A;
	    }


}
