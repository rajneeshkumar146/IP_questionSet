package pep_sns;

import java.util.Arrays;
import java.util.HashMap;

public class count_zeros_xor_pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int[] arr = { 1, 3, 4, 1, 4 };
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			// frequency map
			if (fmap.containsKey(arr[i])) {
				fmap.put(arr[i], fmap.get(arr[i]) + 1);
			} else {
				fmap.put(arr[i], 1);
			}
		}
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i==0 || (i-1 >= 0) && arr[i] != arr[i-1]) {
				int cval = fmap.get(arr[i]);
				count += (cval * (cval - 1)) / 2;
			}
		}
		System.out.println(count);
	}

}
