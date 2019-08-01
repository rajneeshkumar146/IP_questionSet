package Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class Bipartite_Graph {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };

		System.out.println(isbipartitecheck(arr, 0));
	}

	private static boolean Isbipartite(int[][] arr, int src, int[] colour) {
		LinkedList<Integer> queue = new LinkedList<>();
		colour[src] = 1;
		queue.addLast(src);

		while (queue.size() != 0) {
			int rem = queue.removeFirst();
			if (arr[rem][rem] == 1) {
				return false;
			}
			int col = colour[rem];
			for (int i = 0; i < arr.length; i++) {
				if (arr[rem][i] != 0 && (colour[i] == 0)) {
					queue.addLast(i);
					if (col == 1) {
						colour[i] = 2;
					} else {
						colour[i] = 1;
					}
				} else if (arr[rem][i] != 0 && (colour[i] != 0)) {
					if (col == 1 && colour[i] != 2) {
						return false;
					} else if (col == 2 && colour[i] != 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean isbipartitecheck(int[][] arr, int src) {
		int[] colour = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (colour[i] == 0) {
				boolean bool = Isbipartite(arr, i, colour);
				if (bool == false) {
					return false;
				}
			}
		}
		return true;
	}
}
