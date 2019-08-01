package SnS;

import java.util.Scanner;

public class searching_a_number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int flag = -1;
			for (int i = 0; i < n; i++) {
				if (arr[i] == k) {
					flag = 1;
					break;
				}
			}
			System.out.println(flag);
		}
	}
}
