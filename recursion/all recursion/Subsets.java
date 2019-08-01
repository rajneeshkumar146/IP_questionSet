package recursion;

import java.util.*;

public class Subsets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			HashSet<String> set = new HashSet<>();
			Arrays.sort(arr);
			sum(arr, 0, n, "", set);
			System.out.println();
		}
	}

	public static void sum(int arr[], int start, int n, String s, HashSet<String> set) {

		if (start >= n) {
			if (start == n) {
				if (!set.contains(s)) {
					if (s == "")
						System.out.print("(" + ")");
					else
						System.out.print("(" + s.substring(0, s.length() - 1) + ")");
					set.add(s);
				}
			}
			return;
		}

		if (!set.contains(s)) {
			if (s == "")
				System.out.print("(" + ")");
			else
				System.out.print("(" + s.substring(0, s.length() - 1) + ")");
			set.add(s);
		}

		String out = "";
		out = s + arr[start] + " ";
		sum(arr, start + 1, n, out, set);
		sum(arr, start + 1, n, s, set);
	}
}