package recursion;

public class AddAndSearchWord {
	class TrieNode {

		TrieNode[] children;
		boolean isWord;

		public TrieNode() {
			children = new TrieNode[26];
			isWord = false;
		}

	}

	TrieNode root;

	public AddAndSearchWord() {
		root = new TrieNode();
	}

	public void addWord(String word) {

		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.children[ch - 'a'] == null) {
				curr.children[ch - 'a'] = new TrieNode();
			}
			curr = curr.children[ch - 'a'];
		}
		curr.isWord = true;

	}

	public boolean search(String word) {

		TrieNode curr = root;
		boolean found = helper(curr, word, 0);
		return found;

	}

	private boolean helper(TrieNode node, String word, int i) {

		if (i == word.length()) {
			return node.isWord;
		}

		if (word.charAt(i) == '.') {

			for (int j = 0; j < 26; j++) {
				if (node.children[j] != null) {
					if (helper(node.children[j], word, i + 1)) {
						return true;
					}
				}

			}
			return false;

		} else {
			char ch = word.charAt(i);
			if (node.children[ch - 'a'] != null) {
				return helper(node.children[ch - 'a'], word, i + 1);
			} else {
				return false;
			}

		}

	}

	public static void main(String[] ar) {

		
		AddAndSearchWord obj=new AddAndSearchWord();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad"));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search(".ad"));
		System.out.println(obj.search("b.."));
		
		
		
		
		
		
		
		
		
		
	}

}
