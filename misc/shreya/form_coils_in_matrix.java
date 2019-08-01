package misc;

import java.util.Scanner;

public class form_coils_in_matrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();

			// no. of elments in each coil
			int k = 8 * n * n;
			int[] coil1 = new int[k];
			int[] coil2 = new int[k];

			coil1[0] = 8 * n * n + 2 * n;
			int cur = coil1[0];
			int step = 2, move = 1;
			int count = 1;
			while (count < k) {

				for (int i = 0; i < step && count < k; i++) {
					coil1[count] = cur - (4 * n * move);
					cur = coil1[count];
					count++;
				}

				for (int i = 0; i < step && count < k; i++) {
					coil1[count] = cur + move;
					cur = coil1[count];
					count++;
				}

				step += 2;
				move *= -1;
			}

			for (int i = 0; i < k; i++) {
				coil2[i] = 16 * n * n + 1 - coil1[i];
			}

			for (int i = 0; i < k; i++) {
				System.out.print(coil1[i] + " ");
			}
			System.out.println();

			for (int i = 0; i < k; i++) {
				System.out.print(coil2[i] + " ");
			}
			System.out.println();

		}
	}
}
