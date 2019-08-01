package InternQuestGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Circle_of_strings {
	
	static void dfs(ArrayList<ArrayList<Integer>> g, int u, boolean[] visit) {
		visit[u] = true;
		for (int i = 0; i < g.get(u).size(); ++i) {
			int nbr = g.get(u).get(i);

			if (!visit[nbr])
			{
				dfs(g, nbr, visit);
			}
		}
	}

	// Returns true if all vertices are strongly connected
	// i.e. can be made as loop
	static boolean isConnected(ArrayList<ArrayList<Integer>> g, boolean[] mark, int s) {
		// Initialize all vertices as not visited
		boolean visit[] = new boolean[26];

		// perform a dfs from s
		dfs(g, s, visit);

		// now loop through all characters
		for (int i = 0; i < 26; i++) {
			/*
			 * I character is marked (i.e. it was first or last character of
			 * some string) then it should be visited in last dfs (as for
			 * looping, graph should be strongly connected)
			 */
			if (mark[i] && !visit[i])
				return false;
		}

	
		return true;
	}

	

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			String s[] = new String[n];
			for (int i = 0; i < n; i++) {
				s[i] = scn.next();
			}
			ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				Graph.add(new ArrayList<>());
			}
			boolean mark[] = new boolean[26];

			// Initialize indegree and outdegree of every
			// vertex as 0.
			int[] in = new int[26];
			int[] out = new int[26];

			// Process all strings one by one
			for (int i = 0; i < n; i++) {
				// Find first and last characters
				int f = s[i].charAt(0) - 'a';
				int l = s[i].charAt(s[i].length() - 1) - 'a';

				// Mark the characters
				mark[f] = mark[l] = true;

				// increase indegree and outdegree count
				in[l]++;
				out[f]++;

				// Add an edge in graph
				Graph.get(f).add(l);
			}

			boolean ischained = true;
			for (int i = 0; i < 26; i++) {
				if (in[i] != out[i]) {
					System.out.println(0);
					ischained = false;
					break;
				}
			}
			if (ischained) {
				if (isConnected(Graph, mark, s[0].charAt(0) - 'a')) {
					System.out.println(1);

				} else {
					System.out.println(0);
				}
			}

		}
	}

}
