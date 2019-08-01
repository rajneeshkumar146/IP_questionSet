package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class BFS_of_graph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(3);
		list3.add(4);
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(4);
		ArrayList<Integer> list5 = new ArrayList<>();

		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);

		bfs(0, list, new boolean[5]);
	}

	static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		LinkedList<Integer> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();

		queue.addLast(s);

		while (queue.size() != 0) {
			int rem = queue.remove();

			if (visited.contains(rem) == false) {
				System.out.print(rem + " ");
			}

			visited.add(rem);

			for (int val : list.get(rem)) {
				if (visited.contains(val) == false) {
					queue.addLast(val);
				}
			}
		}
	}
}
