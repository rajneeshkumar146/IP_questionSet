package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Print_Binary_Tree_levels_in_sorted_order {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scn.nextInt();
		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			solve(arr);
		}
	}

	// for java. using TreeSet.
	public static void solve2() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			TreeSet<Integer> pq = new TreeSet<Integer>();
			int n = in.nextInt();
			for (int i = 1; i <= n; i++) {
				int ele = in.nextInt();
				pq.add(ele);
				if ((i & (i + 1)) == 0) {
					while (!pq.isEmpty())
						System.out.print(pq.pollFirst() + " ");
					System.out.println("");
				}
			}
			if (!pq.isEmpty()) {
				while (!pq.isEmpty())
					System.out.print(pq.pollFirst() + " ");
				System.out.println("");
			}
		}
	}

	public static void solve1(int[] arr) { // best for C++.

		int level = 0;
		for (int i = 0; i < arr.length; level++) {
			int countOfNode = (int) (Math.pow(2, level)) - 1;

			int j = Math.min(i + countOfNode, arr.length - 1);

			// sort(arr.begin()+i,arr.begin() + j+1); //for c++ using vector.
			Arrays.sort(arr, i, j + 1);

			while (i <= j) {
				System.out.print(arr[i]);
				i++;
			}
			System.out.println();

		}

	}

	// Failed Due To Boxing un-boxing. but best in c++.
	public static void solve(int[] arr) {
		LinkedList<Integer> que = new LinkedList<>();
		LinkedList<Integer> st = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		que.add(0);
		while (!que.isEmpty()) {
			int size = que.size();
			while (size-- > 0) {
				int idx = que.removeFirst();
				st.addFirst(arr[idx]);
				if (idx + 1 < arr.length) {
					que.addLast(idx + 1);
					idx++;
				}

				if (idx + 1 < arr.length) {
					que.addLast(idx + 1);
					idx++;
				}
			}

			while (!st.isEmpty()) {
				sb.append(st.removeFirst() + " ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

}
