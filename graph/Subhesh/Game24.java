package Graph;

import java.util.ArrayList;

public class Game24 {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 8, 7 };
		System.out.println(sol(arr));
	}

	public static boolean sol(int[] nums) {
		ArrayList<Double> A = new ArrayList<Double>();
		for (int v : nums) {
			A.add((double) v);
		}
		return solve(A);
	}

	private static boolean solve(ArrayList<Double> nums) {
		if (nums.size() == 1) {
			if (Math.abs(nums.get(0) - 24) < 0.0001) {
				return true;
			} else {
				return false;
			}
		}

		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.size(); j++) {
				if (i != j) {
					ArrayList<Double> list = new ArrayList<>();
					for (int k = 0; k < nums.size(); k++) {
						if (k != i && k != j) {
							list.add(nums.get(k));
						}
					}
					for (int k = 0; k < 4; k++) {
						if (k < 2 && j > i) {
							continue;
						}
						if (k == 0) {
							list.add(nums.get(i) + nums.get(j));
						}
						if (k == 1) {
							list.add(nums.get(i) * nums.get(j));
						}
						if (k == 2) {
							list.add(nums.get(i) - nums.get(j));
						}
						if (k == 3) {
							if (nums.get(j) != 0) {
								list.add(nums.get(i) / nums.get(j));
							} else {
								continue;
							}
						}
						if (solve(list) == true) {
							return true;
						}
						list.remove(list.size() - 1);
					}
				}
			}
		}
		return false;
	}
}
