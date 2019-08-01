package may28;

import java.util.Scanner;

public class Sum_of_f_ai_aj_over_all_pairs_in_an_array_of_n_integers {

	// f(a[i], a[j]) = a[j] - a[i] , | a[j]-a[i] | > 1
	//
	// 0 , | a[j]-a[i] | <= 1

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					int val = arr[j] - arr[i];
					if (val > 1) {
						sum += val;
					}
				}
			}
			System.out.println(sum);

		}

	}

}
