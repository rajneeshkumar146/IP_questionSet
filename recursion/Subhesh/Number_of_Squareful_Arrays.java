package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Number_of_Squareful_Arrays {

	public static void main(String[] args) {
		int[] a = { 2, 2, 2 };
		System.out.println(numSquarefulPerms(a));
	}

	static HashMap<Integer, Integer> count;
	static HashMap<Integer, List<Integer>> graph;

	public static int numSquarefulPerms(int[] A) {
		count = new HashMap<>();
		graph = new HashMap<>();

		for (int val : A) {
			count.put(val, count.getOrDefault(val, 0) + 1);
		}

		for (int val : count.keySet()) {
			List<Integer> list = new ArrayList<>();
			graph.put(val, list);
		}

		ArrayList<Integer> keys = new ArrayList<>(count.keySet());
		for (int i = 0; i < keys.size(); i++) {
			for (int j = 0; j < keys.size(); j++) {
//				if (i != j) {
				int sum = keys.get(i) + keys.get(j);
				int sqrt = (int) (Math.sqrt(sum));
				int pow = sqrt * sqrt;
				if (sum == pow) {
					graph.get(keys.get(i)).add(keys.get(j));
//					}
				}
			}
		}
		int ans = 0;
		List<Integer> sources = new ArrayList<>(count.keySet());
		for (int val : sources) {
			ans += dfs(val, A.length - 1);
		}
		return ans;
	}

	public static int dfs(int src, int left) {
		count.put(src, count.get(src) - 1);
		int ans = 1;
		if (left != 0) {
			ans = 0;
			for (int y : graph.get(src))
				if (count.get(y) != 0) {
					ans += dfs(y, left - 1);
				}
		}
		count.put(src, count.get(src) + 1);
		return ans;
	}
}
