package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class SentenceSimilarity {

	static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {

		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		LinkedList<LinkedList<String>> pairs = new LinkedList<LinkedList<String>>();
		for (int i = 0; i < 4; i++) {
			pairs.add(new LinkedList<String>());
		}
		pairs.get(0).add("great");
		pairs.get(0).add("good");
		pairs.get(1).add("fine");
		pairs.get(1).add("good");
		pairs.get(2).add("acting");
		pairs.get(2).add("drama");
		pairs.get(3).add("skills");
		pairs.get(3).add("talent");
		System.out.println(areSentencesSimilarTwoEfficient(words1, words2, pairs));

	}

	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2,
			LinkedList<LinkedList<String>> pairs) {

		if (words1.length != words2.length) {
			return false;
		}
		HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
		for (LinkedList<String> list : pairs) {
			if (!graph.containsKey(list.get(0))) {
				graph.put(list.get(0), new HashSet<String>());
			}
			if (!graph.containsKey(list.get(1))) {
				graph.put(list.get(1), new HashSet<String>());
			}
			graph.get(list.get(0)).add(list.get(1));
			graph.get(list.get(1)).add(list.get(0));
		}

		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i])) {
				continue;
			} else {
				boolean res = dfs(graph, words1[i], words2[i], new HashSet<String>());
				if (!res) {
					return false;
				}
			}
		}
		return true;

	}

	private static boolean dfs(HashMap<String, HashSet<String>> graph, String current, String target,
			HashSet<String> visited) {

		if (current.equals(target)) {
			return true;
		}

		if (visited.contains(current)) {
			return false;
		}

		visited.add(current);

		if (graph.containsKey(current)) {
			for (String next : graph.get(current)) {
				if (!visited.contains(next)) {
					boolean res = dfs(graph, next, target, visited);
					if (res) {
						return true;
					}
				}
			}
		}
		return false;

	}

	private static boolean areSentencesSimilarTwoEfficient(String[] words1, String[] words2,
			LinkedList<LinkedList<String>> pairs) {

		if (words1.length != words2.length) {
			return false;
		}

		for (LinkedList<String> pair : pairs) {
			union(pair.get(0), pair.get(1));
		}

		for (int i = 0; i < words1.length; i++) {
			String first = words1[i];
			String second = words2[i];
			String firstParent = find(first);
			String secondParent = find(second);
			if (!firstParent.equals(secondParent)) {
				return false;
			}
		}
		return true;

	}

	public static String find(String word) {
		map.putIfAbsent(word, word);
		while (word != map.get(word)) {
			word = map.get(word);
		}
		return map.get(word);

	}

	public static void union(String first, String second) {

		String firstParent = find(first);
		String secondParent = find(second);
		if (!firstParent.equals(secondParent)) {
			map.put(firstParent, secondParent);
		}

	}

}
