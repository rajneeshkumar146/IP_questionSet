package InternQuestGraph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

import lecture5.array;

public class Kill_Captain_America {
	public static void dfs(ArrayList<ArrayList<Integer>> g, boolean visited[], int s) {
		visited[s] = true;
		for (int i = 0; i < g.get(s).size(); i++) {

			int nbr = g.get(s).get(i);
			if (!visited[nbr]) {

				dfs(g, visited, nbr);
			}

		}
	}

	public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> g, ArrayList<ArrayList<Integer>> gT) {
		g.get(u).add(v);
		gT.get(v).add(u);
	}

	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			ArrayList<ArrayList<Integer>> g = new ArrayList<>();
			ArrayList<ArrayList<Integer>> gT = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				g.add(new ArrayList<Integer>());
				gT.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < m; i++) {
				int u = scn.nextInt() - 1;
				int v = scn.nextInt() - 1;
				addEdge(u, v, g, gT);
			}
			int mother = 0;
			boolean visited[] = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs(gT, visited, i);
					mother = i;
				}

			}

			Arrays.fill(visited, false);
			dfs(gT, visited, mother);
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					count++;
				}
			}
			if (count != n) {
				count = 0;
				System.out.println(count);
			} else {
				count=0;
				Arrays.fill(visited, false);
				dfs(g, visited, mother);
				for (int i = 0; i < n; i++) {
					if (visited[i]) {
						count++;
					}
				}
				System.out.println(count);
			}

		}

	}
}