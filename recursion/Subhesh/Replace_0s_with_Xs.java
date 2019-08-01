package BackTracking;

import java.util.Scanner;

public class Replace_0s_with_Xs {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int m = scn.nextInt();

			char[][] arr = new char[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = scn.next().charAt(0);
				}
			}

			Replace(arr);
		}
	}

	private static void Replace(char[][] arr) {
		char[][] graph = new char[arr.length][arr[0].length];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				graph[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (graph[i][0] == 'O') {
				rec(arr, graph, i, 0);
			}
		}
		for (int i = 0; i < arr[0].length; i++) {
			if (graph[0][i] == 'O') {
				rec(arr, graph, 0, i);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (graph[i][arr[0].length - 1] == 'O') {
				rec(arr, graph, i, arr[0].length - 1);
			}
		}
		for (int i = 0; i < arr[0].length; i++) {
			if (graph[arr.length - 1][i] == 'O') {
				rec(arr, graph, arr.length - 1, i);
			}
		}

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] == '-') {
					System.out.print('O' + " ");
				} else if (graph[i][j] == 'O') {
					System.out.print('X' + " ");
				} else {
					System.out.print(graph[i][j] + " ");
				}
			}
		}
		System.out.println();
	}

	private static void rec(char[][] arr, char[][] graph, int row, int col) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			return;
		}
		if (graph[row][col] == 'X' || graph[row][col] == '-') {
			return;
		}
		graph[row][col] = '-';
		rec(arr, graph, row + 1, col);
		rec(arr, graph, row, col + 1);
		rec(arr, graph, row - 1, col);
		rec(arr, graph, row, col - 1);

	}
}
