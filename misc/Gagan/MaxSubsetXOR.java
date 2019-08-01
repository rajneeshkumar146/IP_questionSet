package misc;

import java.util.Scanner;

public class MaxSubsetXOR {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = s.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = s.nextInt();
			}
			maxSubSetXor(ar);
		}

	}

	public static void maxSubSetXor(int[] set) {

		int index = 0;

		for (int i = 31; i >= 0; i--) {

			int maxIdx = index;
			int max = Integer.MIN_VALUE;

			for (int j = index; j < set.length; j++) {

				if ((set[j] & (1 << i)) != 0 && set[j] > max) {
					max = set[j];
					maxIdx = j;
				}

			}
			if (max == Integer.MIN_VALUE) {
				continue;
			}

			int temp = set[maxIdx];
			set[maxIdx] = set[index];
			set[index] = temp;

			maxIdx = index;
			for (int j = 0; j < set.length; j++) {
				if ((set[j] & (1 << i)) != 0 && j != maxIdx) {
					set[j] = set[maxIdx] ^ set[j];
				}
			}
			index++;

		}

		int res = 0;

		for (int i = 0; i < set.length; i++) {
			res ^= set[i];
		}
		System.out.println(res);

	}

}
