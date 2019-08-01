package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Geek_and_Strings {

	// method_01.======================================================

	static class Trie {
		private final trieNode root;

		private class trieNode {
			Map<Character, trieNode> children;
			boolean endofword;
			int count;

			trieNode() {
				this.endofword = false;
				this.children = new HashMap<>();
				this.count = 0;
			}
		}

		public Trie() {
			root = new trieNode();
		}

		void insert(String word) {
			trieNode current = root;
			for (char c : word.toCharArray()) {
				trieNode temp = current.children.get(c);
				if (temp == null) {
					temp = new trieNode();
					current.children.put(c, temp);
				}
				current.count++;
				current = temp;
			}
			current.count++;
			current.endofword = true;
		}

		int search(String word) {
			trieNode current = root;
			for (char c : word.toCharArray()) {
				trieNode temp = current.children.get(c);
				if (temp == null)
					return 0;
				current = temp;
			}
			// if(current!=null)
			return current.count;
			// return 0;
		}
	}

	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Trie trie = new Trie();
			int n = sc.nextInt();
			while (n-- > 0) {
				String s = sc.next();
				trie.insert(s);
			}
			n = sc.nextInt();
			while (n-- > 0) {
				String test;
				test = sc.next();
				System.out.println(trie.search(test));
			}
		}
	}

	// method_02.========================================================
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		for (int count = 0; count < tests; count++) {
			int listSize = sc.nextInt();
			int maxLength = 0;
			Map<String, Integer> map = new HashMap<>();
			for (int index = 0; index < listSize; index++) {
				String str = sc.next();
				maxLength = Math.max(maxLength, str.length());
				String subStr = "";
				for (int indexStr = 0; indexStr < (str.length()); indexStr++) {
					subStr = subStr + Character.toString(str.charAt(indexStr));
					Integer num = map.get(subStr);
					if (num == null) {
						map.put(subStr, 1);
					} else {
						map.put(subStr, num + 1);
					}
				}
			}

			int querySize = sc.nextInt();
			for (int index = 0; index < querySize; index++) {
				Integer num = map.get(sc.next());
				int min = (num == null) ? 0 : num;
				System.out.println(min);
			}
		}
	}

}
