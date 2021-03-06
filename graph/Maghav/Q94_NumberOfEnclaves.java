
public class Q94_NumberOfEnclaves {
	    public int numEnclaves(int[][] board) {
		        for(int i=0;i<board.length;i++)
		        {
		            for(int j=0;j<board[0].length;j++)
		            {
		                if(i==0||i==board.length-1||j==0||j==board[0].length-1)
		                {
		                    if(board[i][j]==1)
		                    {
		                        Changeto2(board,i,j);
		                    }
		                }
		            }
		        }
		        int ans=0;
		         for(int i=0;i<board.length;i++)
		        {
		            for(int j=0;j<board[0].length;j++)
		            {
		                if((i==0||i==board.length-1) &&(j==0||j==board[0].length-1))
		                {
		                   continue;
		                }
		                else
		                {
		                    if(board[i][j]==1)
		                    {
		                       ans++;
		                    }
		                }
		            }
		        }
		        
		          for(int i=0;i<board.length;i++)
		        {
		            for(int j=0;j<board[0].length;j++)
		            {
		                if(board[i][j]==2)
		                {
		                    board[i][j]=1;
		                }
		            }
		        }
	        return ans;
		        
		    }
		    static void Changeto2(int[][]board,int i, int j)
		    {
		        board[i][j]=2;
		        
		        int[][]dirs={
		            {1,0},
		            {0,1},
		            {0,-1},
		            {-1,0}
		        };
		        
		        for(int[]x:dirs)
		        {
		            int newx=i+x[0];
		            int newy=j+x[1];
		            
		            if(newx>=0 && newx<board.length && newy>=0 && newy<board[0].length
		              && board[newx][newy]==1)
		            {
		                Changeto2(board,newx,newy);
		            }
		        }
	        
	    }

}
