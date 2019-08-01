import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q53_FloydWarshall {
		public static void main (String[] args) throws Exception {
		    
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    
		    int tc=Integer.parseInt(br.readLine());
		    int x=10000000;
		    
		    for(int t=0;t<tc;t++)
		    {
		        int size=Integer.parseInt(br.readLine());
		        int[][]matrix=new int[size][size];
		        
		        for(int i=0;i<matrix.length;i++)
		        {
		            String[]S=br.readLine().split(" ");
		            for(int j=0;j<matrix[0].length;j++)
		            {
		                matrix[i][j]=Integer.parseInt(S[j]);
		            }
		        }
		        
		        for(int d=0;d<matrix.length;d++)
		        {
		            for(int i=0;i<matrix.length;i++)
		            {
		                for(int j=0;j<matrix[0].length;j++)
		                {
		                    if(i!=d && j!=d && matrix[i][d]!=x && matrix[d][j]!=x)
		                    {
		  
		                         matrix[i][j]=Math.min(matrix[i][j],matrix[i][d]+matrix[d][j]);
		                    }
		                }
		            }
		        }
		        
		        for(int i=0;i<matrix.length;i++)
		        {
		            for(int j=0;j<matrix[0].length;j++)
		            {
		                if(matrix[i][j]!=x)
		                System.out.print(matrix[i][j]+" ");
		                else
		                System.out.print("INF ");
		            }
		            System.out.println();
		        }
		        //System.out.println();
		    }
		    
			
		}

}
