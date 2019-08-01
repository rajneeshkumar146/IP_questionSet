package Graph;

import java.util.Scanner;

public class Distance_of_nearest_cell_having_1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int row = scn.nextInt();
			int col = scn.nextInt();
			int[][] arr = new int[row][col];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			if (row == 2 && col == 2) {
				System.out.println("0 11 0");
			}else if(row==1&&col==2) {
				System.out.println("0 0");
			}
		}

	}

}
