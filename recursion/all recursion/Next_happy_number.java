package BackTracking;

import java.util.HashSet;
import java.util.Scanner;

public class Next_happy_number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			happy(n);
		}
	}

	private static void happy(int n) {
		while (true) {
			n++;
			HashSet<Integer> set = new HashSet<>();
			if (istrue(n, set)) {
				break;
			}
		}
		System.out.println(n);
	}

	private static boolean istrue(int n, HashSet<Integer> set) {
		if (n == 1) {
			return true;
		}
		if (set.contains(n) == true) {
			return false;
		}
		int sum = 0;
		set.add(n);
		while (n != 0) {
			int rem = n % 10;
			n = n / 10;
			sum = sum + (rem * rem);
		}
		return istrue(sum, set);
	}
}
