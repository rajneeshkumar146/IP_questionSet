package Tree;

import java.util.Scanner;

public class BBT_counter {

	static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			// long[] strg = new long[n+2];
			// System.out.println(BBT(n+1, strg));
			System.out.println(countBT(n));

		}

	}

	// https://www.geeksforgeeks.org/count-balanced-binary-trees-height-h/     //wrong solution.
	
/*	count(h) = count(h-1) * count(h-2) +  //left and right
	           count(h-2) * count(h-1) +  //left and right are swap so it give different tree.
	           count(h-1) * count(h-1) +  //left and right but full tree down subtree
	           count(h-1) * count(h-1)    //left and right are swap so it give different tree.
	        
	        = 2 * count(h-1) * count(h-2) +  
	          2 * count(h-1) * count(h-1)
	       
	       = count(h-1) * 2*(count(h - 2) + 
	                          count(h - 1))
*/
	// recursive.=======================================================================

	private static long BBT(int n, long[] strg) {
		if (n == 0 || n == 1)
			return 1;
		if (strg[n] != 0)
			return strg[n];
		strg[n] = ((BBT(n - 1, strg) % mod) * (2 * (BBT(n - 2, strg) % mod + BBT(n - 1, strg) % mod) % mod)) % mod;
		return strg[n];

	}

	public static long countBT(int h) {
		long[] c = new long[h + 1];

		// base cases
		c[0] = 1;
		c[1] = 1;

		for (int i = 2; i <= h; ++i)
			c[i] = ((c[i - 1] % mod) * (2 * ((c[i - 2]) % mod + c[i - 1] % mod) % mod) % mod) % mod;

		return c[h];
	}
}
