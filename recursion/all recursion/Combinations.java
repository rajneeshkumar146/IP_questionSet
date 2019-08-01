package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> templist = new ArrayList<>();
		sum3(k, n, ans, templist, 1);
		System.out.println(ans);
	}

	private static void sum3(int k, int n, List<List<Integer>> ans, List<Integer> templist, int cp) {
		if (templist.size() == k) {
			List<Integer> bresult = new ArrayList<>(templist);
			ans.add(bresult);
			return;
		}
		for (int i = cp; i <= n; i++) {
			templist.add(i);
			sum3(k, n, ans, templist, i+1);
			templist.remove(templist.size() - 1);
		}
	}
}
