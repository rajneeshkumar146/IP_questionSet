import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q123_ShortestPathfrom1ton {

		public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			
			int tc=sc.nextInt();
			
			for(int t=0;t<tc;t++)
			{
			    int size=sc.nextInt();
			    
			    int[]dp=new int[size+1];
			    
			    dp[1]=0;
			    
			    for(int j=2;j<=dp.length-1;j++)
			    {
			        if(j-1>=0 && (j%3==0))
			        {
			            dp[j]=1+Math.min(dp[j-1],dp[j/3]);
			        }
			        else if(j%3==0)
			        {
			            dp[j]=1+dp[j/3];
			        }
			        else if(j-1>=0)
			        {
			            dp[j]=1+dp[j-1];
			        }
			    }
			    
			    
			    System.out.println(dp[dp.length-1]);
			}
		}

}
