package aNs1;

public class transforming_chessboard {

	public static void main(String[] args) {
		int[][] board= {{0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}};
		System.out.println(movesToChessboard(board));
		
	}
	 public static int movesToChessboard(int[][] board) {
	        int n=board.length;
	        int rowSwap=0;
	        int colSwap=0;
	        
	        int rowOneCount=0;
	        int colOneCount=0;
	        
	        //checking if every rectangle has either 4 0's or 2 0's and 2 1's
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                if((board[0][0]^board[i][0]^board[0][j]^board[i][j])==1){
	                    return -1;
	                }
	            }
	        }
	        //counting possible row and col to swap 
	        for(int i=0;i<n;i++){
	            
	             rowOneCount+=board[0][i];
	             colOneCount+=board[i][0];
	            
	            if(board[i][0]==i%2){
	                rowSwap++;
	            }
	            if(board[0][i]==i%2){
	                colSwap++;
	            }
	        }
	        
	        
	        if(rowOneCount<n/2||rowOneCount>(n+1)/2){
	            return -1;
	        }
	        
	        
	        if(colOneCount<n/2||colOneCount>(n+1)/2){
	            return -1;
	        }
	        
	        if(n%2==1){
	            if(colSwap%2==1){
	                colSwap=n-colSwap;
	            }
	            
	            if(rowSwap%2==1){
	                rowSwap=n-rowSwap;
	            }
	        }else{
	            
	            colSwap=Math.min(colSwap,n-colSwap);
	            rowSwap=Math.min(rowSwap,n-rowSwap);
	        }
	        
	        return (rowSwap+colSwap)/2;
	    }

}
