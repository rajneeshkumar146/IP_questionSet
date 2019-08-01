package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Ladder2 {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endword = "cog";
		List<String> wordlist = new ArrayList<>();
		wordlist.add("hot");
		wordlist.add("dot");
		wordlist.add("dog");
		wordlist.add("lot");
		wordlist.add("log");
		wordlist.add("cog");
		List<List<String>> ans = findLadders(beginWord, endword, wordlist);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}

	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		HashMap<String, Boolean> visited = new HashMap<>();
		for (int i = 0; i < wordList.size(); i++) {
			String temp = wordList.get(i);
			for (int j = 0; j < temp.length(); j++) {
				String temp1 = temp.substring(0, j) + "*" + temp.substring(j + 1);
				if (hm.containsKey(temp1) == false) {
					ArrayList<String> list = new ArrayList<>();
					list.add(temp);
					hm.put(temp1, list);
				} else {
					hm.get(temp1).add(temp);
				}
			}
		}
		List<List<String>> ans = new ArrayList<>();
		List<String> tans = new ArrayList<>();
		visited.put(beginWord, true);
		dfs(beginWord, endWord, wordList, hm, ans, visited, tans);
		return ans;
	}

	private static void dfs(String beginWord, String endWord, List<String> wordList,
			HashMap<String, ArrayList<String>> map, List<List<String>> ans, HashMap<String, Boolean> visited,
			List<String> tans) {

		for (int i = 0; i < beginWord.length(); i++) {
			String temp = beginWord.substring(0, i) + "*" + beginWord.substring(i + 1);
			if (map.containsKey(temp)) {
				for (String nbrs : map.get(temp)) {
					if (nbrs == endWord) {
						tans.add(endWord);
						ArrayList<String> l = new ArrayList<>(tans);
						ans.add(l);
						return;
					}
					if (visited.containsKey(nbrs) == false) {
						visited.put(nbrs, true);
						tans.add(nbrs);
						dfs(nbrs, endWord, wordList, map, ans, visited, tans);
						tans.remove(tans.size() - 1);
						visited.put(nbrs, false);
					}
				}
			}
		}
	}
}
