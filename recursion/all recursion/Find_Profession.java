package BackTracking;

import java.util.Scanner;

public class Find_Profession {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int level = scn.nextInt();
			int pos = scn.nextInt();
			char ch = profession(level, pos);
			if (ch == 'd') {
				System.out.println("Doctor");
			} else {
				System.out.println("Engineer");
			}
		}
	}

	private static char profession(int level, int pos) {
		if (level == 1) {
			return 'e';
		}

		if (profession(level - 1, (pos + 1) / 2) == 'd') {
			if (pos % 2 == 0) {
				return 'e';
			} else {
				return 'd';
			}
		} else {
			if (pos % 2 == 0) {
				return 'd';
			} else {
				return 'e';
			}
		}
	}
}
