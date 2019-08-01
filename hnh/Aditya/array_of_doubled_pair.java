package may30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class array_of_doubled_pair {
	public static void main(String[] args) {
		int[] a = { 4, -2, 2, -4 };
		System.out.println(canReorderDoubled(a));

	}

	public static boolean canReorderDoubled(int[] A) {
		HashMap<Integer, Integer> hmap = new HashMap<>();

		for (int a : A) {
			hmap.put(a, hmap.getOrDefault(a, 0) + 1);
		}

		ArrayList<Integer> unique_vals = new ArrayList<>(hmap.keySet());
		Collections.sort(unique_vals);

		for (int val : unique_vals) {
			int cnt = hmap.get(val);
			if (cnt == 0) {
				continue;
			}

			if (val == 0) {
				if ((cnt & 1) == 1) {
					return false;
				}
			}

			else {
				int k = val;
				if (val < 0) {

					if ((val & 1) == 1) {
						return false;
					}

					k /= 2;
				} 
				
				else {

					k *= 2;
				}
				
				
				int cntK = hmap.getOrDefault(k, 0);
				
				
				if (cntK < cnt) {
					return false;
				}
				hmap.put(k, cntK - cnt);
			}
		}
		return true;
	}
}
