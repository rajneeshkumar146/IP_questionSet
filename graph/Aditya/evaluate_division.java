package june3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class evaluate_division {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();

		List<String> e1 = new ArrayList<>();
		e1.add("a");
		e1.add("b");

		equations.add(e1);

		List<String> e2 = new ArrayList<>();
		// e2.add("b");
		// e2.add("c");
		//
		// equations.add(e2);

		double[] values = { 0.5 };
		List<List<String>> queries = new ArrayList<>();
		e1 = new ArrayList<>();
		e1.add("a");
		e1.add("b");

		queries.add(e1);

		e2 = new ArrayList<>();
		e2.add("b");
		e2.add("a");

		queries.add(e2);
		e1 = new ArrayList<>();
		e1.add("a");
		e1.add("c");

		queries.add(e1);

		e2 = new ArrayList<>();
		e2.add("x");
		e2.add("y");

		queries.add(e2);

		// e1 = new ArrayList<>();
		// e1.add("x");
		// e1.add("x");
		//
		// queries.add(e1);

		double[] ans = calcEquation(equations, values, queries);
		System.out.println();
	}

	static HashMap<String, HashMap<String, Double>> eqmap = new HashMap<>();

	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		System.out.println();
		for (int i = 0; i < equations.size(); i++) {
			List<String> eq = equations.get(i);
			if (!eqmap.containsKey(eq.get(0))) {
				eqmap.put(eq.get(0), new HashMap<>());
			}
			if (!eqmap.containsKey(eq.get(1))) {
				eqmap.put(eq.get(1), new HashMap<>());
			}

			eqmap.get(eq.get(0)).put(eq.get(1), values[i]);
			eqmap.get(eq.get(1)).put(eq.get(0), 1.0 / values[i]);
		} // EQUATION MAP CREATED

		ArrayList<Double> ans = new ArrayList<>();
		for (int i = 0; i < queries.size(); i++) {
			List<String> eq = queries.get(i);

			if (!eqmap.containsKey(eq.get(0))) {
				ans.add(-1.0);
				continue;
			}

			HashSet<String> visited = new HashSet<>();
			double val = dfs(eq.get(0), eq.get(1), visited);
			if (val > 0) {
				ans.add(val);
			} else {
				ans.add(-1.0);
			}
		}

		double[] db = new double[ans.size()];
		int k = 0;
		for (double d : ans) {
			db[k++] = d;
		}

		return db;

	}

	public static double dfs(String src, String dest, HashSet<String> visited) {
		// if(!eqmap.containsKey(src) || !eqmap.containsKey(dest)){
		// return -1;
		// }
		if (!eqmap.containsKey(src)) {
			return 0;
		}

		if (eqmap.get(src).containsKey(dest)) {
			return eqmap.get(src).get(dest);
		}
		visited.add(src);

		for (String c : eqmap.get(src).keySet()) {
			if (visited.contains(c) == false) {
				double ans = dfs(c, dest, visited);
				if (ans > 0) {
					ans *= eqmap.get(src).get(c);
					return ans;
				}
			}
		}

		return 0;

	}

}
