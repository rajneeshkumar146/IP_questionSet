package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		int k = 3;
		int n = 7;
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> templist = new ArrayList<>();
		sum3(k, n, ans, templist, 1);
		System.out.println(ans);
	}

	private static void sum3(int k, int tar, List<List<Integer>> ans, List<Integer> templist, int cp) {
		if (tar < 0) {
			return;
		}
		if (templist.size() == k) {
			if (tar == 0) {
				List<Integer> bresult = new ArrayList<>(templist);
				ans.add(bresult);
			}
			return;
		}
		for (int i = cp; i <= 9; i++) {
			templist.add(i);
			sum3(k, tar - i, ans, templist, i+1);
			templist.remove(templist.size() - 1);
		}
	}
}
