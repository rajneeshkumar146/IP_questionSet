import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q102_PossiblePaths {
		public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
			
			int tc=sc.nextInt();
			
			for(int t=0;t<tc;t++)
			{
			    int NumberOfNodes=sc.nextInt();
			    
			    int[][]matrix=new int[NumberOfNodes][NumberOfNodes];
			    
			    for(int i=0;i<NumberOfNodes;i++)
			    {
			        for(int j=0;j<NumberOfNodes;j++)
			        {
			            matrix[i][j]=sc.nextInt();
			        }
			    }
			    
			    int start=sc.nextInt();
			    int end=sc.nextInt();
			    int k=sc.nextInt();
			    
			    int[][][]dp=new int[matrix.length][matrix[0].length][k+1];
			    
			    for(int e=0;e<=k;e++)
			    {
			        for(int i=0;i<matrix.length;i++)
			        {
			            for(int j=0;j<matrix[0].length;j++)
			            {
			                if(e==0 && i==j)
			                {
			                    dp[i][j][e]=1;
			                }
			                if(e==1 && matrix[i][j]==1)
			                {
			                    dp[i][j][e]=1;
			                }
			                
			                if(e>1)
			                {
			                    for(int a=0;a<matrix.length;a++)
			                    {
			                        if(matrix[i][a]!=0)
			                        dp[i][j][e]=dp[i][j][e]+dp[a][j][e-1];
			                    }
			                }
			            }
			        }
			        
			    }
			   
			    
			    System.out.println(dp[start][end][k]);
			}
		}

}
