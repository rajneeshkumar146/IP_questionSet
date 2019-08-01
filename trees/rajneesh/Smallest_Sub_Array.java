package Tree;

import java.util.Scanner;

public class Smallest_Sub_Array {
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {

			int r = sc.nextInt(), n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			int l = Integer.MAX_VALUE;
			for (int i = 0; i < n - 1; i++) {

				int hcf = -1;
				for (int j = i + 1; j < n; j++) {

					if (hcf == -1)
						hcf = gcd(a[i], a[j]);
					else
						hcf = gcd(hcf, a[j]);

					if (hcf == r) {
						l = Math.min(l, j - i + 1);
						break;
					}

					// System.out.println(hcf+" "+a[i]+" "+a[j]+" "+i+" "+j);

				}

			}

			if (l == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(l);

		}

	}

	public static int gcd(int x, int y) {

		if (y > x)
			return gcd(y, x);
		else if (y == 0)
			return x;
		else
			return gcd(y, x % y);

	}
}
