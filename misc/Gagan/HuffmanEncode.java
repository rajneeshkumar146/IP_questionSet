package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanEncode {

	private static class Node implements Comparable<Node> {
		Character data;
		int freq;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}
	}

	private HashMap<Character, String> encMap = new HashMap<>();
	private HashMap<String, Character> decMap = new HashMap<>();

	public HuffmanEncode(String feeder) {

		// step 1->Prepare frequencyMap for feeder
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			int f = 0;
			if (fmap.containsKey(feeder.charAt(i))) {
				f = fmap.get(feeder.charAt(i));
			}
			fmap.put(feeder.charAt(i), f + 1);
		}
		// step 2->Prepare Node for each key in frequency map and add in normal priority
		// Queue
		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (Character ch : keys) {
			Node node = new Node();
			node.data = ch;
			node.freq = fmap.get(ch);
			pq.add(node);
		}
		// step 3->Remove two Nodes from Priority Queue till Size of Priority Queue
		// becomes 1
		// Merge the two Nodes and then push into priority Queue
		while (pq.size() > 1) {

			Node one = pq.remove();
			Node two = pq.remove();
			Node mergedNode = new Node();
			mergedNode.freq = one.freq + two.freq;
			mergedNode.left = one;
			mergedNode.right = two;
			pq.add(mergedNode);
		}

		// Step 4->Remove the Last node in Priority Queue and make it the root Node
		Node root = pq.remove();
		// Step 5->Traverse the tree from root And add 1 or 0(left or right) to string
		// so far
		// When reaching the leaf add into EncMap
		traverse(root, "");

	}

	private void traverse(Node node, String codeSoFar) {

		if (node.left == null && node.right == null) {
			encMap.put(node.data, codeSoFar);
			decMap.put(codeSoFar, node.data);
			return;
		}

		traverse(node.left, codeSoFar + 0);
		traverse(node.right, codeSoFar + 1);
	}

	public String encode(String str) {

		String codedString = "";
		for (int i = 0; i < str.length(); i++) {
			codedString += encMap.get(str.charAt(i));
		}
		return codedString;

	}

	public String decode(String str) {

		String decodedString = "";
		int i = 0;
		String s = "";
		while (i < str.length()) {
			s += str.charAt(i) + "";
			if (decMap.containsKey(s)) {
				decodedString += decMap.get(s);
				s = "";
			}
			i++;

		}
		return decodedString;
	}

}
