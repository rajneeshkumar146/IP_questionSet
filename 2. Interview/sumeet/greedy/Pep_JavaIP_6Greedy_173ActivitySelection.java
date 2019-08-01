package interview.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_173ActivitySelection {

	private static class Pair implements Comparable<Pair> {
		int start;
		int finish;

		public Pair(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		public int compareTo(Pair o) {
			return this.finish - o.finish;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] stime = new int[scn.nextInt()];
		for (int i = 0; i < stime.length; i++) {
			stime[i] = scn.nextInt();
		}
		int[] ftime = new int[stime.length];
		for (int i = 0; i < ftime.length; i++) {
			ftime[i] = scn.nextInt();
		}

		Pair[] pairs = new Pair[stime.length];
		for (int i = 0; i < pairs.length; i++) {
			pairs[i] = new Pair(stime[i], ftime[i]);
		}
		solve(pairs);

	}

	public static void solve(Pair[] pairs) {
		Arrays.sort(pairs);

		System.out.println(pairs[0].start + " " + pairs[0].finish);
		int i = 0;
		for (int j = 1; j < pairs.length; j++) {
			if (pairs[j].start >= pairs[i].finish) {
				System.out.println(pairs[j].start + " " + pairs[j].finish);
				i = j;
			}
		}

	}

}
