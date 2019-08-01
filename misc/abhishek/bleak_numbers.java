package june1;

import java.util.Scanner;

public class BleakNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		while (T-- > 0) {
			int n = scn.nextInt();
			if (isBleak(n)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	private static int countSetBits(int n) {

		// Brian Kernighan's Algo Iterative
		int count = 0;

		while (n > 0) {
			n = n & (n - 1);
			count++;
		}

		return count;
	}

	private static int ceillog2(int n) {
		// Returns ceiling of log2(n)
		// for 8 -> 3
		// for 9 -> 4

		int count = 0;
		n--;

		while (n > 0) {
			n = n >> 1;
			count++;
		}
		return count;
	}

	private static boolean isBleak(int n) {

		for (int x = n - ceillog2(n); x < n; x++) {

			if (x + countSetBits(x) == n) {
				return false;
			}
		}
		return true;
	}

}
