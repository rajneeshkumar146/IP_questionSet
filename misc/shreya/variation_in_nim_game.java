package misc;

import java.util.Scanner;

public class variation_in_nim_game {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			int xor = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				xor ^= arr[i];
			}

			if (xor == 0 || n % 2 == 0) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}
