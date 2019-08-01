package misc;

import java.util.Scanner;

public class save_the_nation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		for (int t = 0; t < test; t++) {
			String s = scn.next();
			int fl = (int) Math.floor(Math.sqrt((double) s.length()));
			int cl = (int) Math.ceil(Math.sqrt((double) s.length()));
			int row = 0;
			int col = 0;
			if (fl * cl < s.length()) {
				row = cl;
				col = cl;
			} else {
				row = fl;
				col = cl;
			}
			int k = 0;
			char[][] mat = new char[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (k < s.length()) {
						mat[i][j] = s.charAt(k);
						k++;
					}
				}
			}

			for (int j = 0; j < col; j++) {
				for (int i = 0; i < row; i++) {
					System.out.print(mat[i][j]);
				}
				if (j != col - 1)
					System.out.print(" ");
			}
			System.out.println();

		}

	}
}
