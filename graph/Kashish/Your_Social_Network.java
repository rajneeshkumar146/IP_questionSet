package InternQuestGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Your_Social_Network {

	public static void dfs(ArrayList<ArrayList<Integer>> g, boolean visited[], int s, int d, int arr[]) {
		visited[s] = true;
		for (int i = 0; i < g.get(s).size(); i++) {

			int nbr = g.get(s).get(i);
			if (!visited[nbr]) {
				int a = d + 1;
				arr[nbr] = a;
				dfs(g, visited, nbr, a, arr);
			}

		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < n + 1; i++) {
				g.add(new ArrayList<Integer>());
			}
			for (int i = 2; i < n + 1; i++) {
				int x=scn.nextInt();
				g.get(i).add(x);
			}
			for (int i = 2; i <= n; i++) {
				boolean visited[] = new boolean[n + 1];
				int ans[] = new int[n + 1];
				Arrays.fill(ans, -1);
				dfs(g, visited, i, 0, ans);
				for (int j = 1; j < n; j++) {
					if (ans[j] != -1) {
						System.out.print(i + " " + j + " " + ans[j] + " ");
					}
				}
			}

			System.out.println();

		}
	}

}
