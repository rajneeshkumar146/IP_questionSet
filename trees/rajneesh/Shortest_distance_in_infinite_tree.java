package Tree;

import java.util.Scanner;

public class Shortest_distance_in_infinite_tree {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int i = scn.nextInt();
			int j = scn.nextInt();
			System.out.println(log(i, j));
		}
	}

	public static int log(int i, int j) {
		int ans = 0;
		if (i > j) {
			int temp = i;
			i = j;
			j = temp;
		}

		while (j != i) {
			ans++;
			if (j > i)
				j = j >> 1;
			if (j < i) {
				i = i >> 1;
				ans++;
			}
		}
		System.out.println(ans);
		return ans;

	}

	// 6930886 4289383
	// 44

}
