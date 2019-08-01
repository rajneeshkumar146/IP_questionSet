package Tree;

import java.util.Scanner;

public class Sum_of_k_smallest_elements_in_BST {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			int k = scn.nextInt();

			int[] idx_K = new int[3]; // 0 for index,1 for k and last 2 for res.
			idx_K[1] = k;

			SumOfKthSmallest(arr, idx_K, -1000001, 1000001);
			System.out.println(idx_K[2] + " ");

		}
	}

	public static void SumOfKthSmallest(int[] arr, int[] idx_K, int min, int max) {
		if (idx_K[0] >= arr.length || arr[idx_K[0]] < min || arr[idx_K[0]] > max) {
			return;
		}

		int ele = idx_K[0];
		if (ele > min && ele < max) {
			idx_K[0]++;
			SumOfKthSmallest(arr, idx_K, min, ele);
			if (idx_K[1] != 0) {
				idx_K[1]--;
				idx_K[2] += ele;
			}
			SumOfKthSmallest(arr, idx_K, ele, max);
		}
	}

}
