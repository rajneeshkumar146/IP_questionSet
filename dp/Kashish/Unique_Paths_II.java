package InternQuestDP;

import java.util.Scanner;

public class Unique_Paths_II {
	    public static int uniquePathsWithObstacles(int[][] Grid) {

	        int m = Grid.length;
	        int n = Grid[0].length;

	        if (Grid[0][0] == 1) {
	            return 0;
	        }

	        
	        Grid[0][0] = 1;

	        for (int i = 1; i < m; i++) {
	            if(Grid[i][0]==0){
	            	Grid[i][0]=1;
	            }
	            else{
	            	Grid[i][0]=0;
	            }
	        }

	 
	        for (int i = 1; i < n; i++) {
	        	if(Grid[0][i]==0){
	            	Grid[0][i]=1;
	            }
	            else{
	            	Grid[0][i]=0;
	            }
	        }

	        for (int i = 1; i < m; i++) {
	            for (int j = 1; j < n; j++) {
	                if (Grid[i][j] == 0) {
	                    Grid[i][j] = Grid[i - 1][j] + Grid[i][j - 1];
	                } else {
	                    Grid[i][j] = 0;
	                }
	            }
	        }

	      
	        return Grid[m - 1][n - 1];
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int Grid[][] = {

				{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }

		};
		int totpath = uniquePathsWithObstacles(Grid);
		System.out.println(totpath);

	}

}
