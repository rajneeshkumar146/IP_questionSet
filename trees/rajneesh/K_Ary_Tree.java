package Tree;

import java.util.Scanner;

public class K_Ary_Tree {

	// Total nodes = (k^(h+1) - 1) / (k - 1)
	// Total Leaf nodes = k^h

	/*
	 * In that case, the max. number of nodes would be
	 * 
	 * 1 + k + k^2 + ... + k^(h-1) = (k^h - 1) / (k - 1)
	 */

	static int mod = (int) (1e9 + 7);

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int k = scn.nextInt();
			int height = scn.nextInt();
			System.out.println(kArrayTree(k, height));
		}
	}

	private static long kArrayTree(int k, int height) {
		if (height == 0)
			return 1;

		long pow = kArrayTree(k, height / 2) % mod;
		if ((height & 1) != 0) // oddNumber
			return pow = ((pow * pow) % mod * (k % mod)) % mod;
		return (pow * pow) % mod;
	}
}
