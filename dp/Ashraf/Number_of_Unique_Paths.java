package InternQuestionDP;

import java.util.Scanner;

public class Number_of_Unique_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int r = scn.nextInt();
			int c = scn.nextInt();

			countpath(r, c);
		}
	}

	public static void countpath(int r, int c) {
		int[][] strg = new int[r][c];

		for (int i = 0; i < c; i++)
			strg[0][i] = 1;
		for (int i = 0; i < r; i++)
			strg[i][0] = 1;
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				strg[i][j] = strg[i - 1][j] + strg[i][j - 1];
			}
		}
		System.out.println(strg[r - 1][c - 1]);
	}
}
