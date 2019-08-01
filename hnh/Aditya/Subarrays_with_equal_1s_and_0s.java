package may28;

import java.util.HashMap;
import java.util.Scanner;

public class Subarrays_with_equal_1s_and_0s {
	public static void main(String[] args) {
		// code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			int sum = 0;
			int flag = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == 0) {
					a[i] = -1;
				}
				sum = sum + a[i];
				if (sum == 0) {
					flag++;
				}
				if (hm.containsKey(sum))
					flag += hm.get(sum);
				if (!hm.containsKey(sum))
					hm.put(sum, 1);
				else {
					int x = hm.get(sum);
					hm.put(sum, x + 1);
				}
			}
			System.out.println(flag);
		}
	}
}
