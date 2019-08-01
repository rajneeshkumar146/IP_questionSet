package may31;

import java.util.Scanner;

public class Rotate90Anticlockwise {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		while(T-- > 0){
		int N = s.nextInt();
		
		// initialise matrix
		int[][] mat = new int[N][N];
		
		for(int i=0; i < mat.length; i++){
			for(int j=0; j < mat[0].length; j++){
				mat[i][j] = s.nextInt();
			}
		}
		
		/* Find transpose of the matrix
		 1 2 3       1 4 7
		 4 5 6  ==>  2 5 8
		 7 8 9       3 6 9
		
		*/
		
		for(int i=0; i < mat.length; i++){
			for(int j = i; j < mat[0].length; j++){
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		/* Swap corresponding elements in each column
		 * 
		 *  1 4 7     3 6 9
		 *  2 5 8 ==> 2 5 8
		 *  3 6 9     1 4 7
		 */
		
		for(int j = 0; j < mat[0].length; j++){
			int top = 0;
			int bottom = mat.length - 1;
			
			while(top < bottom){
				// swap elements at top and bottom index
				int temp = mat[top][j];
				mat[top][j] = mat[bottom][j];
				mat[bottom][j] = temp;
				
				top++;
				bottom--;
			}
		}
		
		// print matrix
		for(int i=0; i < mat.length; i++){
			for(int j=0; j < mat[0].length; j++){
				System.out.print(mat[i][j] + " ");
			}
		}
		System.out.println();
	}
	}	
}
