package pep_misc;

public class multiply_matrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 7, 8, 6, 4 }, { 6, 7, 3, 10 }, { 2, 3, 8, 1 }, { 10, 4, 7, 1 } };
		int[][] B = { { 7, 3, 7, 2 }, { 9, 8, 10, 3 }, { 1, 3, 4, 8 }, { 6, 10, 3, 3 } };
		int[][] C = new int[A.length][B.length];
		multiply(A, B, C, 4);
		for(int[] arr: C) {
			for(int val: arr) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void multiply(int A[][], int B[][], int C[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}

}
