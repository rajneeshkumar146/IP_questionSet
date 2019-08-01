package recursion;

import java.util.Scanner;

class PartitionArrayIntoKSubsets {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(isKPartitionPossible(a, n, k));

	}

	public static boolean isKPartitionPossible(int a[], int n, int k) {
		int[] arr = new int[k];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		if (sum % k != 0) {
			return false;
		}
		int div = sum / k;
		boolean[] brr = new boolean[n];
		boolean ans = isPartition(a, n, k, brr, div, 0, 0);
		return ans;
	}

	public static boolean isPartition(int a[], int n, int k, boolean[] brr, int div, int cursum, int start) {
		if (k == 1) {
			return true;
		}
		if (cursum == div) {
			return isPartition(a, n, k - 1, brr, div, 0, 0);
		} else {
			for (int i = start; i < n; i++) {
				if (brr[i] == false && cursum + a[i] <= div) {
					brr[i] = true;
					cursum += a[i];
					if (isPartition(a, n, k, brr, div, cursum, i + 1)) {
						return true;
					}
					brr[i] = false;
					cursum -= a[i];
				}
			}
		}
		return false;
	}

}
