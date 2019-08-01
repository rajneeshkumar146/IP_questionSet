package BackTracking;

import java.util.Scanner;

public class Number_of_Paths {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int row=scn.nextInt();
			int col=scn.nextInt();
			int[][] arr = new int[row][col];
			System.out.println(paths(arr, 0, 0, arr.length - 1, arr[0].length - 1));
		}
	}

	private static int paths(int[][] arr, int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			return 1;
		}
		int ans = 0;
		if (sr + 1 < arr.length) {
			int path1 = paths(arr, sr + 1, sc, dr, dc);
			ans = ans + path1;
		}
		if (sc + 1 < arr[0].length) {
			int path2 = paths(arr, sr, sc + 1, dr, dc);
			ans = ans + path2;
		}
		return ans;
	}
}
