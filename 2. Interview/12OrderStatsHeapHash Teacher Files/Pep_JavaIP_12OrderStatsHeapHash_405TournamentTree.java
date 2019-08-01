package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.Arrays;

public class Pep_JavaIP_12OrderStatsHeapHash_405TournamentTree {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
		lists.add(new ArrayList<>(Arrays.asList(5, 7, 9, 14, 21, 32)));
		lists.add(new ArrayList<>(Arrays.asList(2, 11, 22, 26, 33, 42)));
		lists.add(new ArrayList<>(Arrays.asList(0, 3, 8, 12, 17)));
		lists.add(new ArrayList<>(Arrays.asList(6, 19, 25, 31, 33)));
		lists.add(new ArrayList<>(Arrays.asList(-1, 45, 55)));

		Pep_JavaIP_12OrderStatsHeapHash_405TournamentTree tree = new Pep_JavaIP_12OrderStatsHeapHash_405TournamentTree(
				lists);
		System.out.println(tree.getKthSmallest(3));
	}

	// This stores the addresses of all the nodes.
	ArrayList<Node> data = new ArrayList<>();

	private class Node {
		int idx;
		private ArrayList<Integer> list;
	}

	public Pep_JavaIP_12OrderStatsHeapHash_405TournamentTree(ArrayList<ArrayList<Integer>> lists) {
		// We have store at the ArrayLists the addresses. At first n-1 places, we store
		// null.
		// At next, n places, we store the ith arraylist and node.idx stores its index
		// which is being compared.

		for (int i = 0; i < lists.size() - 1; i++) {
			data.add(null);
		}

		for (int i = 0; i < lists.size(); i++) {
			Node node = new Node();

			node.idx = 0;
			node.list = lists.get(i);

			data.add(node);
		}
	}

	public int getKthSmallest(int k) {
		// In our arraylist we start from n/2-1, and compare the below 2 elements.
		// We store the minimum of the at jth spot of list
		// null is replaced by complete node which contains ith index of particular
		// arraylist and arraylist
		for (int j = data.size() / 2 - 1; j >= 0; j--) {
			int lci = 2 * j + 1;
			int rci = 2 * j + 2;

			Node left = data.get(lci);
			Node right = data.get(rci);

			if (left.list.get(left.idx) < right.list.get(right.idx)) {
				data.set(j, left);
			} else {
				data.set(j, right);
			}
		}

		data.get(0).idx++;

		// adding infinity at the end of list when we have reached at the end of list
		// so that winner never comes from there.
		if (data.get(0).idx == data.get(0).list.size()) {
			data.get(0).list.add(Integer.MAX_VALUE);
		}

		for (int i = 1; i < k; i++) {
			ArrayList<Integer> winnerspath = getwinnerspath();
			for (int j = 0; j < winnerspath.size(); j++) {
				int lci = -1;
				int rci = -1;
				int pi = -1;

				if (winnerspath.get(j) % 2 == 0) {
					rci = winnerspath.get(j);
					lci = rci - 1;
				} else {
					lci = winnerspath.get(j);
					rci = lci + 1;
				}

				pi = (lci - 1) / 2;

				Node left = data.get(lci);
				Node right = data.get(rci);

				if (left.list.get(left.idx) < right.list.get(right.idx)) {
					data.set(pi, left);
				} else {
					data.set(pi, right);
				}
			}

			data.get(0).idx++;
			if (data.get(0).idx == data.get(0).list.size()) {
				data.get(0).list.add(Integer.MAX_VALUE);
			}
		}

		return data.get(0).list.get(data.get(0).idx - 1);
	}

	// Function for the winner's path
	private ArrayList<Integer> getwinnerspath() {
		ArrayList<Integer> winnerspath = new ArrayList<>();
		int idx = 0;
		while (true) {
			int lci = 2 * idx + 1;
			int rci = 2 * idx + 2;

			if (lci >= data.size()) {
				break;
			}

			if (data.get(lci) == data.get(idx)) {
				winnerspath.add(0, lci);
				idx = lci;
			} else {
				winnerspath.add(0, rci);
				idx = rci;
			}
		}

		return winnerspath;
	}

}
