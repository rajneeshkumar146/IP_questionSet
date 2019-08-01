package Graph;

import java.util.Scanner;

public class Sum_of_depenencies_in_a_graph {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			int[] arr = new int[2 * n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(n);
		}
	}
}
