package BackTracking;

import java.util.ArrayList;

public class Minimum_Factorization {

	public static void main(String[] args) {
		int ans = smallestFactorization(48);
		System.out.println(ans);
	}

	public static int smallestFactorization(int a) {
		if (a == 1 || a == 2) {
			return a;
		}
		long ans = 0;
		int temp = a;
		long prd = 1;

		for (int i = 9; i > 1; i--) {
			while (temp % i == 0) {
				temp = temp / i;
				ans = ans + i * prd;
				prd = prd * 10;
			}
		}
		return temp < 2 && ans <= Integer.MAX_VALUE ? (int) ans : 0;
	}
}
