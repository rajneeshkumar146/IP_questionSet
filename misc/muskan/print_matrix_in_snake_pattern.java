package pep_misc;

public class print_matrix_in_snake_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = 3;
		for(int i=0; i<n; i++){
	         if(i%2 == 0){
	             for(int j=0; j<n; j++){
	                 System.out.print(arr[i][j] + " ");
	             }
	         }else{
	             for(int j=n-1; j>=0; j--){
	            	 System.out.print(arr[i][j] + " ");
	             }
	         }
	     }

	}

}
