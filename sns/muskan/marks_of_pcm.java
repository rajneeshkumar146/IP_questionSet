package pep_sns;

import java.util.Arrays;
import java.util.Scanner;

public class marks_of_pcm {
	/*test case
1
10
4 5 12
1 2 3
10 9 6
4 6 5
4 3 2
4 10 10
1 2 16
10 9 32
1 14 10
10 10 4
*/

	public static class Pair implements Comparable<Pair> {
		int p;
		int c;
		int m;

		Pair(int p, int c, int m) {
			this.p = p;
			this.c = c;
			this.m = m;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.p == o.p) {
				if (this.c == o.c) {
					return this.m - o.m;
				} else {
					return o.c - this.c;
				}
			} else {
				return this.p - o.p;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			Pair[] arr = new Pair[n];
			for (int i = 0; i < n; i++) {
				int pm = scn.nextInt();
				int cm = scn.nextInt();
				int mm = scn.nextInt();
				arr[i] = new Pair(pm, cm, mm);
			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i].p + " " + arr[i].c + " " + arr[i].m + "\n");
			}
		}
	}

}
