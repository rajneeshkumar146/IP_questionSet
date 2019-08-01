package HnH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Pairs_of_Non_Coinciding_Points {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {
			int n = scn.nextInt();

			Map<Long, List<Integer>> xm = new HashMap<>();
			Map<Long, List<Integer>> ym = new HashMap<>();

			long[] x = new long[n];
			long[] y = new long[n];

			int count = 0;

			for (int i = 0; i < n; i++) {
				x[i] = scn.nextLong();
				y[i] = scn.nextLong();

				if (xm.containsKey(x[i])) {
					for (int j : xm.get(x[i])) {
						if (y[j] != y[i])
							count++;
					}
				}
				if (ym.containsKey(y[i])) {
					for (int j : ym.get(y[i])) {
						if (x[j] != x[i])
							count++;
					}
				}
				if (xm.get(x[i]) == null)
					xm.put(x[i], new ArrayList<>());
				if (ym.get(y[i]) == null)
					ym.put(y[i], new ArrayList<>());

				xm.get(x[i]).add(i);
				ym.get(y[i]).add(i);
			}

			System.out.println(count);
		}
	}
}
