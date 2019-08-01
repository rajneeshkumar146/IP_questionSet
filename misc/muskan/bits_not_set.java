package pep_misc;

public class bits_not_set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int[] arr = { 1, 3, 5 };
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int countosb = 0;
			for (int j = 0; j < n; j++) {
				// ++ if bit not set
				if ((arr[j] & (1 << i)) == 0) {
					countosb++;
				}
			}
			ans += countosb * (n - countosb) * 2;
		}
		System.out.println(ans);
	}

}
