package BackTracking;

import java.util.Scanner;

public class No_of_paths_in_a_matrix_with_k_coins {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int k = scn.nextInt();
			int n = scn.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			qb = new Integer[k2][k2][k1];
			System.out.println(paths(arr, k, arr.length - 1, arr[0].length - 1));
		}
	}

	static int k2 = 201;
	static int k1 = 201;
	static Integer[][][] qb;

	private static int paths(int[][] arr, int k, int dr, int dc) {
		if (dr == 0 && dc == 0) {
			if (k == arr[dr][dc]) {
				return 1;
			}
			return 0;
		}
		if (k >= 0 && qb[dr][dc][k] != null) {
			return qb[dr][dc][k];
		}
		int ans = 0;
		if (dr - 1 >= 0) {
			int path1 = paths(arr, k - arr[dr][dc], dr - 1, dc);
			ans = ans + path1;
		}
		if (dc - 1 >= 0) {
			int path2 = paths(arr, k - arr[dr][dc], dr, dc - 1);
			ans = ans + path2;
		}
		if (k >= 0) {
			qb[dr][dc][k] = ans;
		}

		return ans;
	}
}
