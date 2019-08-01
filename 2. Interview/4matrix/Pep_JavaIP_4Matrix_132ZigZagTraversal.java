package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_132ZigZagTraversal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofrows = scn.nextInt();
		int noofcol = scn.nextInt();
		int[][] arr = new int[noofrows][noofcol];
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofcol; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		zigzagtraverse(arr);
	}

	private static void zigzagtraverse(int[][] arr) {
		//printing zigzag pattern with first column
		for (int i = 0; i < arr.length; i++) {
			int temp = i;
			int j = 0;
			while (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length) {
				System.out.print(arr[i][j] + " ");
				i--;
				j++;
			}
			i = temp;
			System.out.println();
		}
		//printing zigzag pattern with last last row
		for (int j = 1; j < arr.length; j++) {
			int temp=j;
			int i=arr.length-1;
			while (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length) {
				System.out.print(arr[i][j] + " ");
				i--;
				j++;
			}
			j=temp;
			System.out.println();
		}
	}

}

/*Test cases:
5
4
  1     2     3     4
  5     6     7     8
  9    10    11    12
 13    14    15    16
 17    18    19    20
 -------------------------------
1 
5 2 
9 6 3 
13 10 7 4 
17 14 11 8 
18 15 12 
19 16 
20

4
4
  1     2     3     4
  8     9     7     8
  9    10    11    12
 13    14    15    16
 -------------------------------
1 
8 2 
9 9 3 
13 10 7 4 
14 11 8 
15 12 
16 

Source: https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
*/