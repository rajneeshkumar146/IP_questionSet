package Graph;

import java.util.Arrays;

public class Minimum_Swaps_to_sort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 1 };
		System.out.println(minSwaps(arr, arr.length));
	}

	public static int minSwaps(int[] A, int N) {
		Pair[] arr = new Pair[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Pair(A[i], i);
		}

		int ans = 0;
		Arrays.sort(arr);
		boolean[] visited = new boolean[N];
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == true || arr[i].idx == i) {
				continue;
			} else {
				int cycle = 0;
				int j = i;
				while (!visited[j]) {
					visited[j] = true;
					cycle++;
					j = arr[j].idx;
				}
				ans += (cycle - 1);
			}
		}
		return ans;
	}

	private static class Pair implements Comparable<Pair> {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}
}
