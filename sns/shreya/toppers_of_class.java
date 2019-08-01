package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class toppers_of_class {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = scn.nextInt();
			pair[] arr = new pair[n];
			for (int i = 0; i < n; i++) {
				int marks = scn.nextInt();
				arr[i] = new pair(marks, i);
			}
			int k = scn.nextInt();
			findToppers(arr, k);
		}
	}

	public static class pair implements Comparable<pair> {
		int marks;
		int idx;

		public pair(int m, int i) {
			this.marks = m;
			this.idx = i;
		}

		public int compareTo(pair o) {
			if (this.marks == o.marks) {
				return this.idx - o.idx;
			} else {
				return o.marks - this.marks;
			}
		}
	}

	public static void findToppers(pair[] arr, int k) {
		Arrays.sort(arr);
		int i = 0;
		while (i < arr.length) {
			System.out.print(arr[i].idx + " ");
			k--;
			i++;
			while (i < arr.length && arr[i].marks == arr[i - 1].marks) {
				System.out.print(arr[i].idx + " ");
				i++;
			}
			if (k == 0) {
				break;
			}

		}
		System.out.println();
	}
}
