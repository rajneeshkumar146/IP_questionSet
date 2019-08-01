package BackTracking;

import java.util.Scanner;

public class GF_Series {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		long[] arr = new long[16];
		arr[1] = 0;
		arr[2] = 1;
		for (int i = 3; i < arr.length; i++) {
			arr[i] = (arr[i - 2] * arr[i - 2]) - (arr[i - 1] );
		}
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			for(int i=1;i<=n;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}
