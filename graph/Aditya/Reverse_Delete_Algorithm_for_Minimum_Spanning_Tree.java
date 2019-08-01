package june4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Reverse_Delete_Algorithm_for_Minimum_Spanning_Tree {
	static class edge implements Comparable<edge> {
		public int v1;
		public int v2;
		public int w;

		public edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return o.w - this.w;
		}

	}

	static int[][] graph;
	static int src = -1;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int v = scn.nextInt();
			int e = scn.nextInt();

			PriorityQueue<edge> pq = new PriorityQueue<>();
			src = -1;
			graph = new int[v][v];

			for (int ec = 0; ec < e; ec++) {
				int v1 = scn.nextInt();
				if (src == -1) {
					src = v1;
				}
				int v2 = scn.nextInt();
				int w = scn.nextInt();

				pq.add(new edge(v1, v2, w));

				graph[v1][v2] = w;
				graph[v2][v1] = w;

			}

			int ans = 0;

			while (pq.size() != 0) {
				edge eg = pq.poll();

				if (!isDisconnectSafe(eg, v)) {
					graph[eg.v1][eg.v2] = 0;
					graph[eg.v2][eg.v1] = 0;
				} else {
					ans += eg.w;
				}
			}

			System.out.println(ans);

		}

	}

	static boolean isDisconnectSafe(edge eg, int vertices) {

		graph[eg.v1][eg.v2] = 0;
		graph[eg.v2][eg.v1] = 0;

		LinkedList<Integer> qu = new LinkedList<>();
		qu.addLast(src);
		boolean[] visited = new boolean[vertices];
		visited[src] = true;
		int count = 0;

		while (qu.size() != 0 && count <= vertices) {
			int poped = qu.removeFirst();

			count++;

			for (int i = 0; i < vertices; i++) {
				if (graph[poped][i] != 0 && visited[i] == false) {
					qu.addLast(i);
					visited[i] = true;
				}
			}
		}

		graph[eg.v1][eg.v2] = eg.w;
		graph[eg.v2][eg.v1] = eg.w;

		if (count == vertices) {
			return false;
		}
		return true;
	}

}
