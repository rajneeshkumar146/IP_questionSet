package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class X_Total_Shapes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {
			String[] arr1 = br.readLine().split(" ");
			int m = Integer.parseInt(arr1[0]);
			int n = Integer.parseInt(arr1[1]);

			String[] arr2 = br.readLine().split(" ");
			char[][] arr = new char[m][n];
			for (int i = 0; i < arr2.length; i++) {
				for (int j = 0; j < arr2[i].length(); j++) {
					arr[i][j] = arr2[i].charAt(j);
				}
			}
			TotalShapes(arr);
		}
	}

//		TotalShapes(new char[][] { { 'O', 'O', 'O', 'O', 'X', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O', 'X' },
//				{ 'X', 'X', 'X', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'X', 'X', 'O', 'O', 'O' } });
//
//		TotalShapes(new char[][] { { 'X', 'X', 'O' }, { 'O', 'O', 'X' }, { 'O', 'X', 'O' }, { 'O', 'O', 'O' },
//				{ 'X', 'O', 'X' }, { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'X', 'O' }, { 'X', 'X', 'X' },
//				{ 'O', 'O', 'O' } });

	// Consider the Os as zeros and Xs as 1s.
	static void TotalShapes(char[][] A) {
		boolean[][] visited = new boolean[A.length][A[0].length];
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 'X' && visited[i][j] == false) {
					counter++;
					Dfs(A, visited, i, j);
				}
			}
		}
		System.out.println(counter);
	}

	static void Dfs(char[][] A, boolean[][] visited, int i, int j) {
		visited[i][j] = true;

		int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }

		};

		for (int[] x : dirs) {
			int newx = i + x[0];
			int newy = j + x[1];

			if (newx >= 0 && newx < A.length && newy >= 0 && newy < A[0].length && A[newx][newy] == 'X'
					&& visited[newx][newy] == false) {
				Dfs(A, visited, newx, newy);
			}
		}
	}

}
