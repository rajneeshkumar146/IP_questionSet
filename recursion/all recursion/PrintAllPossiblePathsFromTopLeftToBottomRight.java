package recursion;

public class PrintAllPossiblePathsFromTopLeftToBottomRight {

	public static void main(String[] args) {

		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 } };
		printMatrix(mat, 0, 0, new int[mat.length+mat[0].length-1], 0);
		
	}

	public static void printMatrix(int mat[][], int i, int j, int path[], int idx) {
		path[idx] = mat[i][j];

		if (i == mat.length - 1) {
			for (int k = j + 1; k < mat[0].length; k++) {
				path[idx + k - j] = mat[i][k];
			}
			for (int l = 0; l < idx + mat[0].length - j; l++) {
				System.out.print(path[l] + " ");
			}
			System.out.println();
			return;
		}

		if (j == mat[0].length - 1) {
			for (int k = i + 1; k < mat.length; k++) {
				path[idx + k - i] = mat[k][j];
			}
			for (int l = 0; l < idx + mat.length - i; l++) {
				System.out.print(path[l] + " ");
			}
			System.out.println();
			return;
		}
		printMatrix(mat, i + 1, j, path, idx + 1);

		printMatrix(mat, i, j + 1, path, idx + 1);
	}
}
