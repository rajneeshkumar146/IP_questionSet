package InternQuestionDP;

import java.util.Scanner;

public class Partition_Equal_Subset_Sum {

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
			System.out.println(IsPartition(a));
		}

	}

	public static boolean IsPartition(int a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		if (sum % 2 != 0) {
			return false;
		}

		boolean strg[][] = new boolean[sum / 2 + 1][a.length + 1];

		for (int i = 0; i <= sum / 2; i++) {
			for (int j = 0; j <= a.length; j++) {
				if (i == 0)
					strg[i][j] = true;
				else if (j == 0 && i != 0)
					strg[i][0] = false;
				else {
					if (strg[i][j - 1]) {
						strg[i][j] = true;
					} else {
						if (i >= a[j - 1])
							strg[i][j] = strg[i - a[j - 1]][j-1];
					}
				}
			}
		}
//		for (int i = 0; i <= sum / 2; i++) {
//			for (int j = 0; j < strg[0].length; j++)
//				System.out.print(strg[i][j] + " ");
//			System.out.println();
//		}
		return strg[sum / 2][a.length];
	}

}
