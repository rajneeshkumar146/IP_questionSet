package misc;

import java.util.Arrays;
import java.util.Scanner;

public class help_a_thief {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int tp = scn.nextInt();
			int n = scn.nextInt();
			pair[] arr = new pair[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new pair(scn.nextInt(), scn.nextInt());
			}
			int plateReq = tp;
			int res = 0;
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				if (plateReq > 0) {
					int p = plateReq - arr[i].np >= 0 ? arr[i].np : plateReq;
					res += (p * arr[i].coins);
					plateReq -= p;
				} else {
					break;
				}
			}
			System.out.println(res);
		}
	}

	public static class pair implements Comparable<pair> {
		int np;
		int coins;

		pair(int np, int nc) {
			this.np = np;
			this.coins = nc;
		}

		public int compareTo(pair o) {
			if (this.coins == o.coins) {
				return this.np - o.np;
			} else {
				return o.coins - this.coins;
			}
		}
	}
}
