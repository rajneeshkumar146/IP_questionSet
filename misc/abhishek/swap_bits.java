package june1;

import java.util.Scanner;

public class SwapBits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		
		while(T-- > 0){
			int x = scn.nextInt();
			int p1 = scn.nextInt();
			int p2 = scn.nextInt();
			int n = scn.nextInt();
			System.out.println(swapBits(x, p1, p2, n));
		}
	}

	private static int swapBits(int x, int p1, int p2, int n){
		// n - number, p1 - position 1, p2 - position 2, n - number of bits at p1 and p2
		
		int set1 = (x >> p1) & ((1 << n) - 1);
		
		int set2 = (x >> p2) & ((1 << n) - 1);
		
		int xor = (set1 ^ set2);
		
		xor = (xor << p1) | (xor << p2);
		
		int result = x ^ xor;
		
		return result;
		
	}
}
