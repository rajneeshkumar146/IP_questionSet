package may29;

import java.util.HashSet;
import java.util.Scanner;

public class incomplete_array {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			HashSet<Integer> freqmap = new HashSet<>();
			int n = scn.nextInt();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int val = scn.nextInt();
				max = Math.max(max, val);
				min = Math.min(min, val);
				freqmap.add(val);
			}

			int ans = max - min - 1 - freqmap.size() + 2;

			if (ans < 0)
				System.out.println(0);

			else
				System.out.println(ans);

		}
	}

}
