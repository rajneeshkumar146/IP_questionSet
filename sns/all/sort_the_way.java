package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sort_the_way {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int i = 0; i < test; i++) {
			int n = scn.nextInt();
			int[] vac = new int[n];
			int[] pat = new int[n];
			for (int j = 0; j < n; j++) {
				vac[j] = scn.nextInt();
			}
			for (int j = 0; j < n; j++) {
				pat[j] = scn.nextInt();
			}

			Arrays.sort(vac);
			Arrays.sort(pat);
			int flag = 1;
			for (int j = 0; j < n; j++) {
				if (vac[j] < pat[j]) {
					flag = 0;
					break;
				}
			}
			System.out.println(flag);
		}

	}
}
