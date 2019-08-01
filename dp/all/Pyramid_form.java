package InternQuestDP;

import java.util.Scanner;

public class Pyramid_form {
	public static int minPyramidCost(int arr[])

	{
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = Math.min(arr[0], 1);

		for (int i = 1; i < n; ++i) {
			left[i] = Math.min(arr[i], Math.min(left[i - 1] + 1, i + 1));
		}

		right[n - 1] = Math.min(arr[n - 1], 1);

		for (int i = n - 2; i >= 0; --i) {
			right[i] = Math.min(arr[i], Math.min(right[i + 1] + 1, n - i));
		}

		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = Math.min(right[i], left[i]);
		}

		int max_ind = 0;
		for (int i = 0; i < n; ++i)
			if (dp[i] > dp[max_ind]) {
				max_ind = i;
			}

		int cost = 0;
		int height = dp[max_ind];

		for (int x = max_ind; x >= 0; --x) {
			cost += arr[x] - height;
			if (height > 0) {
				--height;
			}
		}
		height = dp[max_ind] - 1;
		for (int x = max_ind + 1; x < n; ++x) {
			cost += arr[x] - height;
			if (height > 0) {
				--height;
			}
		}
		return cost;
	}

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
			System.out.println(minPyramidCost(arr));
		}

	}

}
