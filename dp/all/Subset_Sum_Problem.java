package InternQuestDP;

import java.util.Scanner;

public class Subset_Sum_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();

			}
			boolean ispartitionpos = findpartition(arr);

			if (ispartitionpos) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static boolean findpartition(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		if (sum % 2 == 1) {
			return false;
		}

		boolean partition[][] = new boolean[sum / 2 + 1][arr.length + 1];
		for (int i = 0; i < partition[0].length; i++) {
			partition[0][i] = true;
		}
		for (int i = 1; i < partition.length; i++) {
			partition[i][0] = false;
		}

		for (int i = 1; i < partition.length; i++) {
			for (int j = 1; j < partition[0].length; j++) {
				if (i >= arr[j - 1]) {
					partition[i][j] = partition[i][j - 1] || partition[i - arr[j - 1]][j - 1];
				} else {
					partition[i][j] = partition[i][j - 1];
				}
			}
		}

		return partition[sum / 2][arr.length];
	}

}
