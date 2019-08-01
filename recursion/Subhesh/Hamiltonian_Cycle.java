package BackTracking;

public class Hamiltonian_Cycle {

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };

		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		System.out.println(cycle(graph, visited, 0, 0, 0));
	}

	private static boolean cycle(int[][] graph, boolean[] visited, int src, int osrc, int pos) {
		if (pos == graph.length - 1) {
			if (graph[src][osrc] == 1) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < graph[0].length; i++) {
			if (visited[i] == false && graph[src][i] == 1) {
				visited[i] = true;
				boolean ans = cycle(graph, visited, i, osrc, pos + 1);
				if (ans == true) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
}
