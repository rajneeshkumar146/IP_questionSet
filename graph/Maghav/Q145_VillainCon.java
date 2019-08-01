import java.util.*;
import java.lang.*;
import java.io.*;
public class Q145_VillainCon {

	    static int[]dp;
		public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			
			int tc=sc.nextInt();
			
			for(int t=0;t<tc;t++)
			{
			    int number=sc.nextInt();
			    
			    ArrayList<ArrayList<Integer>>matrix=new ArrayList<>();
			    for(int k=0;k<=number;k++)
			    {
			        ArrayList<Integer>A=new ArrayList<>();
			        matrix.add(A);
			    }
			    
			    int cases=sc.nextInt();
			    
			    for(int i=0;i<cases;i++)
			    {
			        int a=sc.nextInt();
			        int b=sc.nextInt();
			        matrix.get(a).add(b);
			    }
			    
			    dp=new int[number+1];
			    int ans=0;
			    for(int i=2;i<=number;i++)
			    {
			        dp[i]=Dfs(i,matrix);
			    }
			    
			    for(int i=0;i<dp.length;i++)
			    {
			        ans=Math.max(ans,dp[i]);
			    }
			    
			    System.out.println(ans);
			}
		}
		static int Dfs(int vertex,ArrayList<ArrayList<Integer>>matrix)
		{
		    int ans=0;
		    
		   if(dp[vertex]!=0)
		   {
		       return dp[vertex];
		   }
		    
		    for(int i=0;i<matrix.get(vertex).size();i++)
		    {
		        ans=Math.max(ans,Dfs(matrix.get(vertex).get(i),matrix));
		    }
		    dp[vertex]=ans+1;
		    return ans+1;
		}

}
