package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_146ShortestPathInMatrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		int sr = scn.nextInt();
		int sc = scn.nextInt();
		int dr = scn.nextInt();
		int dc = scn.nextInt();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		shortestpath(arr, sr, sc, dr, dc, visited, 0);
		System.out.println(max);
	}

	static int max = Integer.MAX_VALUE;

	private static void shortestpath(int[][] arr, int sr, int sc, int dr, int dc, boolean[][] visited, int count) {
		// positive base case
		if (sr == dr && sc == dc) {
			if (count < max) {
				max = count;
			}
			return;
		}
		// negative base case
		if (isvalid(arr, sr, sc, dr, dc, visited) == false) {
			return;
		}

		visited[sr][sc] = true;
		shortestpath(arr, sr + 1, sc, dr, dc, visited, count + 1);
		shortestpath(arr, sr - 1, sc, dr, dc, visited, count + 1);
		shortestpath(arr, sr, sc + 1, dr, dc, visited, count + 1);
		shortestpath(arr, sr, sc - 1, dr, dc, visited, count + 1);
		visited[sr][sc] = false;

	}

	private static boolean isvalid(int[][] arr, int sr, int sc, int dr, int dc, boolean[][] visited) {
		if (sr < 0 || sr >= arr.length || sc < 0 || sc >= arr[0].length) {
			return false;
		}
		if (arr[sr][sc] == 0) {
			return false;
		}
		if (visited[sr][sc] == true) {
			return false;
		}
		return true;
	}

}

/*
Test cases:
	
	5 5
	1 0 1 1 1
	1 0 1 0 1
	1 1 1 0 1
	0 0 0 0 1
	1 1 1 0 1
	0 0
	4 4
	----------------------
	12
	
	5 5
	1 0 1 1 1
	1 0 1 0 1
	1 1 1 0 1
	0 0 0 0 1
	1 1 1 0 1
	0 0
	3 4
	----------------------
	11
	
	5 5
	1 0 1 1 1
	1 1 1 0 1
	1 1 0 0 1
	0 0 0 0 1
	1 1 1 0 1
	0 0
	0 2
	----------------------
	4
	
	Source: https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
	
	
*/