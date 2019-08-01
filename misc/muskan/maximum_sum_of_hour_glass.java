package pep_misc;

public class maximum_sum_of_hour_glass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 0, 0 }, { 0, 0, 0, 0, 0 }, { 2, 1, 4, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 0 } };
		int n = arr.length;
		int m = arr[0].length;
		if (n < 3 || m < 3) {
			System.out.println("-1");
			return;
		}
		long maxsum = Integer.MIN_VALUE;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				long sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				maxsum = Math.max(sum, maxsum);
			}
		}
		System.out.println(maxsum);

	}

}
