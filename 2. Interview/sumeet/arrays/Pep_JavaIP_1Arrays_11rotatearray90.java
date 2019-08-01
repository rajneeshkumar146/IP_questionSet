package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_11rotatearray90 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int[][] arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = scn.nextInt();
			}
		}

		solve(arr);
	}

	private static void solve(int[][] arr) {
		// transpose
		for (int r = 0; r < arr.length; r++) {
			for (int c = r; c < arr[0].length; c++) {
				swap(arr, r, c, c, r);
			}
		}

		// for clockwise, we reverse the columns
		for (int left = 0, right = arr[0].length - 1; left < right; left++, right--) {
			for (int r = 0; r < arr.length; r++) {
				swap(arr, r, left, r, right);
			}
		}

		// print
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	private static void swap(int[][] arr, int r1, int c1, int r2, int c2) {
		int temp = arr[r1][c1] ^ arr[r2][c2];
		arr[r1][c1] ^= temp;
		arr[r2][c2] ^= temp;
	}

}
