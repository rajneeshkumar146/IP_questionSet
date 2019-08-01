package pep_sns;

import java.util.HashMap;

public class count_zeros_in_sorted_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{0,0,0},{0,0,1},{0,1,1}};
		System.out.println(countZeroes(arr, 3));
	}

	private static int countZeroes(int[][] A, int N)
	{
	    int count = 0;
	for(int i=0; i<N; i++){
	    for(int j=0; j<N; j++){
	        if(A[i][j] == 0)
	        count++;
	        if(A[i][j] == 1)
	        break;
	    }
	}
	return count;
	}
}
