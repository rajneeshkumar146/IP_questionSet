package june1;

import java.util.Scanner;

public class SwapTwoNibbles {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt();
		while(T-- > 0) {
			int n = scn.nextInt();
			System.out.println(swapTwoNibbles(n));
		}
	}

	private static int swapTwoNibbles(int n) {
		
		return ( (n & 0x0f) << 4  |  (n & 0xf0) >> 4);
		
	}

}
