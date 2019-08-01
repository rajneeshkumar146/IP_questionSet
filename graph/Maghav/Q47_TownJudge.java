import java.util.*;
public class Q47_TownJudge {
	    public int findJudge(int N, int[][] trust) {
	        
	        ArrayList<ArrayList<Integer>>original=new ArrayList<>();
	        ArrayList<ArrayList<Integer>>reverse=new ArrayList<>();
	        
	        for(int i=0;i<=N;i++)
	        {
	            ArrayList<Integer>a=new ArrayList<>();
	            ArrayList<Integer>b=new ArrayList<>();
	            
	            original.add(a);
	            reverse.add(b);
	        }
	        
	        for(int []pos:trust)
	        {
	            int src=pos[0];
	            int dest=pos[1];
	            
	            original.get(src).add(dest);
	            reverse.get(dest).add(src);
	        }
	        
	        for(int i=1;i<=N;i++)
	        {
	            if(original.get(i).size()==0 && reverse.get(i).size()==N-1)
	            {
	                return i;
	            }
	        }
	        return -1;
	    }

}
