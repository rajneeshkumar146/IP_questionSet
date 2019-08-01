package may31;

import java.util.Scanner;

public class FindPerimeterOfShapes {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while (T-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();

			int[][] arr = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			System.out.println(findPerimeter(arr, n, m));

		}
	}

	static int numofneighbour(int mat[][], int i, int j) {

		int count = 0;

		// UP
		if (i > 0 && mat[i - 1][j] == 1)
			count++;

		// LEFT
		if (j > 0 && mat[i][j - 1] == 1)
			count++;

		// DOWN
		if (i < mat.length - 1 && mat[i + 1][j] == 1)
			count++;

		// RIGHT
		if (j < mat[0].length - 1 && mat[i][j + 1] == 1)
			count++;

		return count;
	}

	public static int findPerimeter(int[][] mat, int n, int m) {
		int perimeter = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1)
					perimeter += (4 - numofneighbour(mat, i, j));
			}
		}
		return perimeter;
	}

}
