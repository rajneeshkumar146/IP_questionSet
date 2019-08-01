package Tree;

import java.util.Scanner;

public class Optimal_binary_search_tree {
	public static int sum(int f[], int i, int j) {
		int s = 0;
		for (int k = i; k <= j; k++) {
			if (k >= f.length)
				continue;
			s += f[k];
		}
		return s;
	}

	public static int cost(int f[], int n) {
		int c[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++)
			c[i][i] = f[i];

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i <= n - l + 1; i++) {
				int j = i + l - 1;
				c[i][j] = Integer.MAX_VALUE;
				for (int r = i; r <= j; r++) {
					int d = ((r > i) ? c[i][r - 1] : 0) + ((r < j) ? c[r + 1][j] : 0) + sum(f, i, j);
					if (d < c[i][j])
						c[i][j] = d;
				}
			}
		}
		return c[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int q = 0; q < t; q++) {
			int n = s.nextInt();
			int k[] = new int[n];
			int f[] = new int[n];
			for (int i = 0; i < n; i++)
				k[i] = s.nextInt();
			for (int i = 0; i < n; i++)
				f[i] = s.nextInt();
			System.out.println(cost(f, n));
		}
	}
}
