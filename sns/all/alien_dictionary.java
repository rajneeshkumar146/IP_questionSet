package pep_sns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class alien_dictionary {

	public static class Graph {
		int vertices;
		HashSet<Character> letters = new HashSet<>();
		HashMap<Character, ArrayList<Character>> edges = new HashMap<>();

		Graph(int v) {
			this.vertices = v;
		}

		public void addEdge(char u, char v) {
			if (!edges.containsKey(u) && !edges.containsKey(v)) {
				edges.put(u, new ArrayList<Character>());
				edges.put(v, new ArrayList<Character>());
			} else if (!edges.containsKey(u) && edges.containsKey(v)) {
				edges.put(u, new ArrayList<Character>());
			} else if (edges.containsKey(u) && !edges.containsKey(v)) {
				edges.put(v, new ArrayList<Character>());
			}
			edges.get(u).add(v);
		}
	}

	public static void main(String[] args) {
		// { "caa", "aaa", "aab" } 3 3
		int now = 5; // no of words
		int nol = 4; // no of letters
		String[] aow = { "baa", "abcd", "abca", "cab", "cad" }; // arr of words in dictionary
		String unique = aliendict(aow, now, nol);
		System.out.println(unique);
	}

	public static String aliendict(String[] aow, int now, int nol) {
		String ans = "";

		// create a graph with nol vertices
		Graph g = new Graph(nol);

		// loop into each pair
		for (int i = 0; i < now - 1; i++) {
			String w1 = aow[i];
			String w2 = aow[i + 1];
			// min length
			int minlen = Math.min(w1.length(), w2.length());
			for (int j = 0; j < minlen; j++) {
				// if char not in letters set till now, add
				if (!g.letters.contains(w1.charAt(j))) {
					g.letters.add(w1.charAt(j));
				}
				if (!g.letters.contains(w2.charAt(j))) {
					g.letters.add(w2.charAt(j));
				}

				// if char is diff
				if (w1.charAt(j) != w2.charAt(j)) {
					g.addEdge(w1.charAt(j), w2.charAt(j));
					break;
				}
			}
		}

		// topological sort
		ans = topologicalsort(g);

		return ans;
	}

	public static String topologicalsort(Graph g) {
		Stack<Character> st = new Stack<>();
		HashSet<Character> visited = new HashSet<>();
		for (char ch : g.letters) {
			if (!visited.contains(ch)) {
				topo_helper(ch, g, visited, st);
			}
		}
		String ans = "";
		while (st.size() != 0) {
			ans += st.pop();
		}
		return ans;
	}

	private static void topo_helper(char ch, Graph g, HashSet<Character> visited, Stack<Character> st) {
		// TODO Auto-generated method stub
		visited.add(ch);
		for (int i = 0; i < g.edges.get(ch).size(); i++) {
			char v = g.edges.get(ch).get(i);
			if (!visited.contains(v)) {
				topo_helper(v, g, visited, st);
			}
		}
		st.push(ch);
	}

}
