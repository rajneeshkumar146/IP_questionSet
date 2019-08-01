package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Water_Connection_Problem {
	static int ans;

	static int Dfs(int vertex, int[] start, int[] end, int[] distance) {
		if (start[vertex] == 0) // Yahan se aage aur koi raasta nahi
		{
			return vertex;
		}

		if (ans > distance[vertex]) // Minimum pipe diameter chahiye pure component ki
		{
			ans = distance[vertex];
		}
		return Dfs(start[vertex], start, end, distance);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] start = new int[n + 1];
			int[] end = new int[n + 1];
			int[] distances = new int[n + 1];

			for (int i = 0; i < p; i++) {
				int startvertex = sc.nextInt();
				int endvertex = sc.nextInt();
				int distance = sc.nextInt();

				start[startvertex] = endvertex;
				distances[startvertex] = distance;
				end[endvertex] = startvertex;
			}
			int counter = 0;
			ArrayList<Integer> startanswer = new ArrayList<>();
			ArrayList<Integer> endanswer = new ArrayList<>();
			ArrayList<Integer> distanceanswer = new ArrayList<>();

			for (int j = 1; j <= n; j++) {
				if (start[j] > 0 && end[j] == 0) {
					counter++;
					ans = Integer.MAX_VALUE;

					int finalend = Dfs(j, start, end, distances); // Finding the end of the connected component

					startanswer.add(j);
					endanswer.add(finalend); // Adding the final end
					distanceanswer.add(ans); // static variable for finding minimum distance

				}
			}
			System.out.println(counter); // Number of disconnected components

			for (int i = 0; i < startanswer.size(); i++) {
				System.out.print(startanswer.get(i) + " " + endanswer.get(i) + " " + distanceanswer.get(i));
				System.out.println();
			}
		}
	}
}
