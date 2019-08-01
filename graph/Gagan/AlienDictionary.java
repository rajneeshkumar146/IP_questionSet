package graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class AlienDictionary {

	public static void main(String[] args) {

		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(alienOrder(words));
	}

	public static String alienOrder(String[] words) {

		HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();

		// Adding all the vertex(Character) to the graph
		for (String s : words) {
			for (char ch : s.toCharArray()) {
				if (!graph.containsKey(ch))
					graph.put(ch, new LinkedList<Character>());
			}
			if (graph.size() == 26) {
				break;
			}

		}

		// Traversing through all the words and adding the edge to the character when we
		// know the order
		for (int i = 0; i < words.length - 1; i++) {
			int j = 0;
			int lenFirst = words[i].length();
			int lenSecond = words[i + 1].length();
			while (j < Math.min(lenFirst, lenSecond) && words[i].charAt(j) == words[i + 1].charAt(j)) {
				j++;
			}
			if (j < Math.min(lenFirst, lenSecond)) {
				graph.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
			}
		}

		// Applying DFS from all the vertices
		int[] visited = new int[26];
		StringBuilder sb = new StringBuilder();
		for (char ch : graph.keySet()) {
			if (visited[ch - 'a'] == 0) {
				if (dfs(graph, ch, visited, sb)) {
					return "";
				}
			}
		}
		return sb.reverse().toString();

	}

	// If there is a cycle then return true
	// If in the DFS of any vertex any vertex is already visited that means there is
	// a cycle
	private static boolean dfs(HashMap<Character, LinkedList<Character>> graph, char ch, int[] visited,
			StringBuilder sb) {

		visited[ch - 'a'] = 1;

		for (char ch1 : graph.get(ch)) {
			if (visited[ch1 - 'a'] == 1) {
				return true;
			} else if (visited[ch1 - 'a'] == 0) {
				boolean res = dfs(graph, ch1, visited, sb);
				if (res) {
					return true;
				}
			}
		}
		// As this character is already visited but this can present in dfs of other
		// character so to avoid returning true for a cycle
		visited[ch - 'a'] = 2;
		sb.append(ch);

		return false;
	}

}
