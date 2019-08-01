package june1;

import java.util.Scanner;

public class morning_assembly {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = scn.nextInt();
			int[] heights = new int[n];

			for (int i = 0; i < n; i++) {
				heights[i] = scn.nextInt();
			}

			int[] dp = new int[n + 1];

			for (int height : heights) {
				dp[height] = dp[height - 1] + 1; // the biggest nuber in arr
													// tells about the size of
													// the longest consecutive
													// sequence
			}

			int max = 0;
			for (int i = 0; i < dp.length; i++) {
				if (max < dp[i]) {
					max = dp[i];
				}
			}

			System.out.println(n - max); // rest need to be rearranged

		}

	}

}
