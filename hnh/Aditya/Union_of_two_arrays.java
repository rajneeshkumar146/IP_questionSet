package may27;

import java.util.HashMap;
import java.util.Scanner;

public class Union_of_two_arrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = scn.nextInt();
			int m = scn.nextInt();

			int[] arr1 = new int[n];
			int[] arr2 = new int[m];

			HashMap<Integer, Integer> unionMap = new HashMap<>();

			for (int i = 0; i < n; i++) {
				arr1[i] = scn.nextInt();

				if (unionMap.containsKey(arr1[i])) {
					unionMap.put(arr1[i], unionMap.get(arr1[i]) + 1);
				} else {
					unionMap.put(arr1[i], 1);
				}
			}

			for (int i = 0; i < m; i++) {
				arr2[i] = scn.nextInt();
				if (unionMap.containsKey(arr2[i])) {
					unionMap.put(arr2[i], unionMap.get(arr2[i]) + 1);
				} else {
					unionMap.put(arr2[i], 1);
				}
			}

			// intersectiom
			// int count = 0;
			// for (int itr : unionMap.keySet()) {
			// if (unionMap.get(itr) > 1) {
			// count++;
			// }
			// }
			//
			// System.out.println(count);

			// union
			System.out.println(unionMap.size());
		}

	}

}
