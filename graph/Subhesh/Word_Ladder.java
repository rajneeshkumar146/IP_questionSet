package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Word_Ladder {

	class Pair {
		int steps;
		String current;

		Pair(String Y, int x) {
			this.steps = x;
			this.current = Y;
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int len = beginWord.length();
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		HashMap<String, Boolean> visited = new HashMap<>();
		for (String X : wordList) {
			for (int i = 0; i < len; i++) {
				String temp = X.substring(0, i) + "*" + X.substring(i + 1);
				if (hm.containsKey(temp)) {
					hm.get(temp).add(X);
				} else {
					ArrayList<String> list = new ArrayList<>();
					list.add(X);
					hm.put(temp, list);
				}
			}
		}

		LinkedList<Pair> Q = new LinkedList<>();
		Q.addLast(new Pair(beginWord, 1));

		while (Q.size() > 0) {
			Pair rem = Q.pop();

			for (int i = 0; i < len; i++) {
				String check = rem.current.substring(0, i) + "*" + rem.current.substring(i + 1);

				if (hm.containsKey(check)) {
					for (String x : hm.get(check)) {
						if (x.equals(endWord)) {
							return rem.steps + 1;
						} else if (!visited.containsKey(x)) {
							Q.addLast(new Pair(x, rem.steps + 1));
							visited.put(x, true);
						}
					}
				}
			}
		}
		return 0;
	}
}
