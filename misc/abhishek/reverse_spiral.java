package may31;

import java.util.ArrayList;
import java.util.Scanner;

public class reverseSpiral {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int m = s.nextInt();
		int n = s.nextInt();
		
		int[][] mat = new int[m][n];
		
		for(int i=0; i < m ; i++){
			for(int j=0; j < n; j++){
				mat[i][j] = s.nextInt();
			}
		}
		spiral(mat);
		
	}
	
	
	public static void spiral(int[][] arr) {
		
		ArrayList<Integer> res = new ArrayList<>();
		
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
				res.add(arr[rmin][col]);
				count++;
			}
			rmin++;
			// right wall
			for (int row = rmin; row <= rmax && count <= tne; row++) {
				res.add(arr[row][cmax]);
				count++;
			}
			cmax--;
			// bottom wall
			for (int col = cmax; col >= cmin && count <= tne; col--) {
				res.add(arr[rmax][col]);
				count++;
			}
			rmax--;
			// left wall
			for (int row = rmax; row >= rmin && count <= tne; row--) {
				res.add(arr[row][cmin]);
				count++;
			}
			cmin++;
		}

		for(int i=res.size() - 1; i >=0; i--){
			System.out.print(res.get(i) + " ");
		}
		
		
		}
		
		
	}

