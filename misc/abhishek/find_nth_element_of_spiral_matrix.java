package may31;


import java.util.Scanner;

public class FindNthElementOfSpiralMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
			int r = s.nextInt();
			int c = s.nextInt();
			int k = s.nextInt();
			int[][] arr = new int[r][c];
	
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			spiral(arr, k);
		}
	}

	public static void spiral(int[][] arr, int k) {

		int tne = arr.length * arr[0].length;

		//// Clockwise Spiral
		int rmin = 0;
		int rmax = arr.length - 1;
		int cmin = 0;
		int cmax = arr[0].length - 1;

		int count = 1;
		while (count <= tne) {
			// top wall
			for (int col = cmin; col <= cmax && count <= tne; col++) {
				if (count == k){
					System.out.println(arr[rmin][col]);
					return;
				}
				count++;
			}
			rmin++;
			// right wall
			for (int row = rmin; row <= rmax && count <= tne; row++) {
				if (count == k){
					System.out.println(arr[row][cmax] + " ");
					return;
				}
				count++;
			}
			cmax--;
			// bottom wall
			for (int col = cmax; col >= cmin && count <= tne; col--) {
				if (count == k){
					System.out.println(arr[rmax][col] + " ");
					return;
				}
				count++;
			}
			rmax--;
			// left wall
			for (int row = rmax; row >= rmin && count <= tne; row--) {
				if (count == k){
					System.out.println(arr[row][cmin] + " ");
					return;
				}
				count++;
			}
			cmin++;
		}

		
	}

}