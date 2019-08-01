package InternQuestionDP;

import java.util.Scanner;

public class Minimum_Cost_To_Make_Two_Strings_Identical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			String str1 = scn.next();
			String str2 = scn.next();

			int mat[][] = new int[str1.length() + 1][str2.length() + 1];
			for (int i = 1; i <= str1.length(); i++) {
				for (int j = 1; j <= str2.length(); j++) {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						mat[i][j] = mat[i - 1][j - 1] + 1;
					} else {
						mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
					}
				}
			}
			for (int c[] : mat) {
				for (int v : c) {
					System.out.print(v + " ");
				}
				System.out.println();
			}
			int lcs = mat[str1.length()][str2.length()];
			int cost = (str1.length() - lcs) * x;
			cost += (str2.length() - lcs) * y;
			System.out.println(cost);
		}
	}
}
