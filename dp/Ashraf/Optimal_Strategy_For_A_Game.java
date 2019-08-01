package InternQuestionDP;

import java.util.Scanner;

public class Optimal_Strategy_For_A_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = scn.nextInt();
			}

			int table[][] = new int[n][n];

			for (int gap = 0; gap < n; ++gap) {
				for (int i = 0, j = gap; j < n; ++i, ++j) {

					int x = 0, y = 0, z = 0;

					if ((i + 2) <= j) {
						x = table[i + 2][j];
					}
					if ((i + 1) <= (j - 1)) {
						y = table[i + 1][j - 1];
					}
					if (i <= (j - 2)) {
						z = table[i][j - 2];
					}

					int f1 = Math.min(x, y);
					int f2 = Math.min(y, z);
					table[i][j] = Math.max(a[i] + f1, a[j] + f2);
				}
			}
//			for (int v[] : table) {
//				for (int c : v)
//					System.out.print(c + " ");
//				System.out.println();
//			}
			System.out.println(table[0][n - 1]);
		}
	}

}
