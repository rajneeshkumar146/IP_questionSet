package pep_sns;

import java.util.Arrays;

public class minimum_product_of_k_integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 3;

		long pr = 1;
		long mod = (long) Math.pow(10, 9) + 7;
		if (k == 0) {
			System.out.println("1");
		} else {
			Arrays.sort(arr);
			for (int i = 0; i < k; i++) {
				pr = pr * arr[i];
				pr = pr % mod;
			}
			System.out.println(pr % mod);
		}
	}

}
