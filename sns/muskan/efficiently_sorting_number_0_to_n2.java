package pep_sns;

public class efficiently_sorting_number_0_to_n2 {
	/*
	 * 5 24 12 0 15 8
	 */

	public static void main(String[] args) {
		int n = 7;
		int[] arr = { 40, 12, 45, 32, 33, 1, 22 };
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(arr[i], max);
		}
		for (int exp = 1; max / exp > 0; exp *= 10) {
			count(arr, n, exp);
		}
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void count(int[] arr, int n, int exp) {
		int[] map = new int[10];
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			map[(arr[i] / exp) % 10]++;
		}
		for (int i = 1; i < 10; i++) {
			map[i] += map[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			temp[map[(arr[i] / exp) % 10] - 1] = arr[i];
			map[(arr[i] / exp) % 10]--;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
	}

}
