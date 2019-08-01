
public class Q83_MinSwapsToSort {
	public static int minSwaps(int[] A, int N)
		{
		     boolean[]visited=new boolean[N+1];
		     int i=0;
		     int ans=0;
		     
		     while(i<A.length)
		     {
		         int cycle=1;
		         if(i+1<visited.length-1 && visited[i+1]==false)
		         {
		             visited[i+1]=true;
		             int num=A[i];
		             while(visited[num]!=true)
		             {
		                 visited[num]=true;
		                 cycle++;
		                 num=A[num-1];
		             }
		             
		             ans=ans+(cycle-1);
		         }
		         i++;
		     }
		     return ans;
	    } 
}
