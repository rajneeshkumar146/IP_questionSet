package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinsAndGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {
			String[] st = br.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int k = Integer.parseInt(st[1]);

			coins(n, k);
		}
	}

	private static void coins(int n, int k) {
		int[] arr = new int[k];
		for (int i = 2; i < k; i++) {
			if (i % 2 == 0) {
				arr[i] = 1;
			}
		}
		arr[0] = n - ((k - 1) / 2);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
