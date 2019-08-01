package InternQuestAS1;

import java.util.Scanner;

public class Transpose_Matrix {
	 public static int[][] transpose(int[][] mat) {
		 int R = mat.length, C = mat[0].length;
	        int[][] ans = new int[C][R];
	        for (int r = 0; r < R; ++r)
	            for (int c = 0; c < C; ++c) {
	                ans[c][r] = mat[r][c];
	            }
	        return ans;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);

	}

}
