package Tree;

import java.util.Scanner;

public class Does_array_represent_Heap {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			solve(arr);
		}
	}

	private static void solve(int[] arr) {
		boolean flag = true;
		for (int i = 1; i < arr.length; i++) {
			int idx = (i - 1) >> 1;
			if (arr[idx] < arr[i]) {
				flag = false;
				break;
			}

		}
		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
