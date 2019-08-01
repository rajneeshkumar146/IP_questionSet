package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];

	public Graph(int v) {

		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}

	}

	public void addEdge(int v, int w) {

		adj[v].add(w);

	}

	public void dfsTPSort(int v, boolean[] visited, Stack stack) {

		visited[v] = true;
		Iterator<Integer> it = adj[v].iterator();
		Integer i;
		while (it.hasNext()) {

			i = it.next();
			if (!visited[i]) {
				dfsTPSort(i, visited, stack);
			}

		}
		stack.push(Integer.valueOf(v));
	}

	public void topologicalSorting() {
		boolean[] visited = new boolean[this.V];
		Stack stack = new Stack();
		for (int i = 0; i < this.V; i++) {
			if (!visited[i]) {
				dfsTPSort(i, visited, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}

	}

	public static void main(String[] ar) {

		Graph g = new Graph(6);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(4, 0);
		g.addEdge(4, 1);

		g.topologicalSorting();

	}

}
