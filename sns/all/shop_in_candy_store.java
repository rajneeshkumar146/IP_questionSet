package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class shop_in_candy_store {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] prices = new int[n];
			for (int i = 0; i < n; i++) {
				prices[i] = scn.nextInt();
			}
			Arrays.sort(prices);

			int minCost = 0;
			int maxCost = 0;
			int j = n - 1;
			for (int i = 0; i <= j; i++, j -= k) {
				minCost += prices[i];
			}
			j = 0;
			for (int i = n - 1; i >= j; j += k, i--) {
				maxCost += prices[i];
			}
			System.out.println(minCost + " " + maxCost);

		}
	}
}
