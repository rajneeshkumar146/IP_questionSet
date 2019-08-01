package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Find_if_there_is_a_path_of_more_than_k_lengh {

	public static void main(String[] args) {
		ArrayList<ArrayList<Pair>> list = new ArrayList<>();

		ArrayList<Pair> list0 = new ArrayList<>();
		list0.add(new Pair(1, 10));
		list0.add(new Pair(3, 20));
		ArrayList<Pair> list1 = new ArrayList<>();
		list1.add(new Pair(0, 10));
		list1.add(new Pair(2, 10));
		ArrayList<Pair> list2 = new ArrayList<>();
		list2.add(new Pair(1, 10));
		list2.add(new Pair(3, 10));
		ArrayList<Pair> list3 = new ArrayList<>();
		list3.add(new Pair(0, 20));
		list3.add(new Pair(2, 10));
		ArrayList<Pair> list4 = new ArrayList<>();
		list4.add(new Pair(3, 15));
		list4.add(new Pair(5, 2));
		list4.add(new Pair(6, 5));
		ArrayList<Pair> list5 = new ArrayList<>();
		list5.add(new Pair(4, 2));
		list5.add(new Pair(6, 7));
		ArrayList<Pair> list6 = new ArrayList<>();
		list6.add(new Pair(5, 7));
		list6.add(new Pair(4, 5));

		list.add(list0);
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);
		list.add(list6);
		boolean[] visited = new boolean[list.size()];
		int src = 0;
		visited[src] = true;
		System.out.println(dfs(list, visited, src, 0, 59));
	}

	private static boolean dfs(ArrayList<ArrayList<Pair>> list, boolean[] visited, int src, int csf, int k) {
		if (csf >= k) {
			return true;
		}
		ArrayList<Pair> nbr = list.get(src);
		for (int i = 0; i < nbr.size(); i++) {
			Pair pair = nbr.get(i);
			if (visited[pair.vtx] == false) {
				visited[pair.vtx] = true;
				boolean ans = dfs(list, visited, pair.vtx, csf + pair.wt, k);
				visited[pair.vtx] = false;
				if (ans == true) {
					return true;
				}
			}
		}
		return false;
	}

	public static class Pair {
		int vtx;
		int wt;

		public Pair(int vtx, int wt) {
			this.vtx = vtx;
			this.wt = wt;
		}
	}
}
