package BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Print_Pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(n);
			pattern(n, ans, false);
			for (int val : ans) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}

	private static void pattern(int n, ArrayList<Integer> ans, boolean flag) {
		if (ans.get(ans.size() - 1) == n && ans.size() != 1) {
			return;
		}
		if (flag == false) {
			ans.add(ans.get(ans.size() - 1) - 5);
		} else {
			ans.add(ans.get(ans.size() - 1) + 5);
		}
		if (ans.get(ans.size() - 1) <= 0) {
			flag = true;
		}
		pattern(n, ans, flag);
	}
}
