package pep_misc;

public class print_matrix_in_diagonal_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = 3;
		printMatrixDiagonal(mat, n);
		System.out.println();
		System.out.println('z' - 'a');
		
	}
	
	public static void printMatrixDiagonal(int mat[][], int n)
    {
        int i = 0;
        int j = 0;
        boolean upwards = true;
         for(int k=0; k<n*n;){
             if(upwards){
                 for(; i>=0 && j < n; i--, j++){
                     System.out.print(mat[i][j] + " ");
                     k++;
                 }
                 if(i < 0 && j <= n - 1){
                     i = 0;
                 }
                 if(j == n){
                     i = i + 2;
                     j--;
                 }
             }else{
                 for(; j >= 0 && i < n; i++, j--){
                     System.out.print(mat[i][j] + " ");
                     k++;
                 }
                 if(j < 0 && i <= n - 1){
                     j = 0;
                 }
                 if(i == n){
                     j = j + 2;
                     i--;
                 }
             }
             upwards = !upwards;
         }
    }

}
