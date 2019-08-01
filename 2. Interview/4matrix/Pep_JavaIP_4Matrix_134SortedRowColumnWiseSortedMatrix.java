package Matrix;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_4Matrix_134SortedRowColumnWiseSortedMatrix {

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
		sortmatrix(arr);
	}

	private static void sortmatrix(int[][] arr) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int row = 0; row < arr.length; row++) {
			pq.add(new Pair(arr[row][0], row, 0));
		}

		while (!pq.isEmpty()) {
			Pair pair = pq.remove();
			System.out.print(pair.value+" ");
			if (pair.col+1 != arr[0].length)
				pq.add(new Pair(arr[pair.row][pair.col+1], pair.row, pair.col+1));
		}
	}

	static class Pair implements Comparable<Pair> {
		int value;
		int row;
		int col;

		public Pair(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}

		public int compareTo(Pair o) {
			return this.value - o.value;
		}
	}

}
/*
Test cases:
3
3
1 2 3 
4 5 6
7 8 9
---------------------
1 2 3 4 5 6 7 8 9

6 4
1 2 3 4
5 6 7 8
6 8 10 12
12 13 14 15
15 16 17 18
20 21 22 24
--------------------
1 2 3 4 5 6 6 7 8 8 10 12 12 13 14 15 15 16 17 18 20 21 22 24

4 4 
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50
--------------------
10 15 20 25 27 29 30 32 33 35 37 39 40 45 48 50 

Source: https://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/

*/