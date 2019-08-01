package InternQuestionDP;

public class Minimum_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m2[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(maze(m2));
	}

	public static int maze(int[][] m) {
		int f[][] = new int[m.length][m[0].length];

		for (int i = f.length - 1; i >= 0; i--) {
			for (int j = f[0].length - 1; j >= 0; j--) {
				if (i == f.length - 1 && j == f[0].length - 1) {
					f[i][j] = m[i][j];
				} else if (i == f.length - 1) {
					f[i][j] = m[i][j] + f[i][j + 1];
				} else if (j == f[0].length - 1) {
					f[i][j] = m[i][j] + f[i + 1][j];
				} else {
					f[i][j] = m[i][j] + Math.min(f[i + 1][j], f[i][j + 1]);
				}
			}
		}
//		for (int i = 0; i < f.length; i++) {
//			for (int j = 0; j < f[0].length; j++) {
//				if (f[i][j] / 10 == 0) {
//					System.out.print(0+""+f[i][j] + " ");
//				} else
//					System.out.print(f[i][j] + " ");
//			}
//			System.out.println();
//		}
		return f[0][0];
	}
}
