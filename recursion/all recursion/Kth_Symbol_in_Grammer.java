package BackTracking;

public class Kth_Symbol_in_Grammer {

	public static void main(String[] args) {
		int N = 2;
		int K = 1;

		System.out.println(Symbol(N, K));
	}

	private static char Symbol(int n, int k) {
		if (n == 1) {
			return '0';
		}
		char ch = Symbol(n - 1, (k + 1) / 2);
		if (ch == '0') {
			if (k % 2 == 0) {
				return '1';
			} else {
				return '0';
			}
		} else {
			if (k % 2 == 0) {
				return '0';
			} else {
				return '1';
			}
		}
	}
}
