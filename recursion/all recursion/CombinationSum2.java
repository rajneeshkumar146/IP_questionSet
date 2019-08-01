package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			int k = scn.nextInt();
			Arrays.sort(arr);
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < arr.length - 1; i++) {
				list.add(arr[i]);
			}
			list.add(arr[arr.length - 1]);
			List<List<Integer>> ans = new ArrayList<>();
			List<Integer> templist = new ArrayList<>();
			sum1(list, k, ans, templist, 0);
			System.out.println(ans);
		}
	}

	private static void sum1(List<Integer> list, int k, List<List<Integer>> ans, List<Integer> templist, int cpos) {
		if (k < 0) {
			return;
		}
		if (k == 0) {
			List<Integer> bresult = new ArrayList<>(templist);
			ans.add(bresult);
			return;
		}
		for (int i = cpos; i < list.size(); i++) {
			templist.add(list.get(i));
			sum1(list, k - list.get(i), ans, templist, i+1);
			templist.remove(templist.size() - 1);
			while (i < (list.size() - 1) && (list.get(i) == list.get(i + 1))) {
				i++;
			}
		}
	}
}
