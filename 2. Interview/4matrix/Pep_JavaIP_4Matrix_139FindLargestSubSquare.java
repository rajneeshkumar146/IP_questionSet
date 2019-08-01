package Matrix;
//Assuming that the given matrix is square
import java.util.Scanner;

public class Pep_JavaIP_4Matrix_139FindLargestSubSquare {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofrows = scn.nextInt();
		
		char[][] arr = new char[noofrows][noofrows];
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofrows; j++) {
				arr[i][j] = scn.next().charAt(0);
			}
		}

		System.out.println(solve(arr));
	}

	private static int solve(char[][] arr) {
		int[][] ver = new int[arr.length][arr[0].length];
		int[][] hor = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 'O') {
					ver[i][j] = 0;
					hor[i][j] = 0;
				} else {
					hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
					ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
				}
			}
		}
		int max = 1;

		for (int i = arr.length - 1; i >= 1; i--) {
			for (int j = arr[0].length - 1; j >= 1; j--) {
				// Find smaller of values in hor[][] and ver[][]
				// A Square can only be made by taking smaller
				// value
				int small = Math.min(hor[i][j], ver[i][j]);

				// At this point, we are sure that there is a right
				// vertical line and bottom horizontal line of length
				// at least 'small'.

				// We found a bigger square if following conditions
				// are met:
				// 1)If side of square is greater than max.
				// 2)There is a left vertical line of length >= 'small'
				// 3)There is a top horizontal line of length >= 'small'
				while (small > max) {
					if (ver[i][j - small + 1] >= small && hor[i - small + 1][j] >= small) {
						max = small;
					}
					small--;
				}
			}
		}
		return max;
	}

}
/*
Test cases:
6
X O O O O O 
X X X X O O
X O O X O O
X O O X O O
X X X X O O
X O O O O O
-----------------------------
4	

6
X O O O O O 
X X X X O O
X O O X O O
X O O X O O
X X X X O O
X X X X X X
-----------------------------
4

6
X O O O O O 
X X X X X O
X O O X X O
X O O X X O
X X X X X O
X X X X X X
----------------------
5

Source: https://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/
*/