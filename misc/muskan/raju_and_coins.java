package pep_misc;

import java.util.HashSet;

public class raju_and_coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 14;
		int[] arr = { 4, 6, 12, 8 };
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		int count = 0;
		int dollars = 0;
		int val = 1;
		while (dollars + val <= k) {
			if (!set.contains(val)) {
				set.add(val);
				count++;
				dollars += val;
			}
			val++;
		}
		System.out.println(count);

	}

}
