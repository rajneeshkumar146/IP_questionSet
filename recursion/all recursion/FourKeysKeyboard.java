

public class FourKeysKeyboard {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			System.out.println(printMaxAs(i) + " " + printMaxAs(i, new int[i + 1]) + " " + printMaxAsTabulation(i));
			System.out.println();
		}

	}

	public static int printMaxAs(int n) {

		if (n <= 6) {
			return n;
		}

		int max = 0;
		for (int b = n - 3; b >= 1; b--) {
			int maxAsUptoBreakPoint = printMaxAs(b);
			int currAs = maxAsUptoBreakPoint * (n - b - 1);
			if (currAs > max) {
				max = currAs;
			}
		}

		return max;

	}

	public static int printMaxAs(int n, int[] qb) {

		if (qb[n] != 0) {
			return qb[n];
		}

		if (n <= 6) {
			qb[n] = n;
			return n;
		}

		int max = 0;
		for (int b = n - 3; b >= 1; b--) {
			int maxUptoBreakPoint = printMaxAs(b);
			int currAs = maxUptoBreakPoint * (n - b - 1);
			if (currAs > max) {
				max = currAs;
			}
		}
		qb[n] = max;

		return max;

	}

	public static int printMaxAsTabulation(int n) {

		if (n <= 6) {
			return n;
		}

		int[] res = new int[n + 1];
		for (int i = 1; i <= 6; i++) {
			res[i] = i;
		}

		for (int x = 7; x <= n; x++) {

			int max = 0;
			for (int b = x - 3; b >= 1; b--) {
				int curr = (x - b - 1) * res[b];
				if (curr > max) {
					res[x] = curr;
					max = res[x];
				}
			}

		}
		return res[n];

	}
}
