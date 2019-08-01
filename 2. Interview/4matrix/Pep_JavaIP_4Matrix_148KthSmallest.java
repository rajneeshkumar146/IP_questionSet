package Matrix;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_4Matrix_148KthSmallest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];
		// the input array is row wise and column wise sorted matrix
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		int k = scn.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		// add all the elements of the first column
		for (int row = 0; row < arr.length; row++) {
			pq.add(new Pair(arr[row][0], row, 0));
		}

		// remove minimum element and add next k times
		Pair rp=null; 
		for (int i = 0; i < k; i++) {
			rp = pq.remove();
			if (rp.colno + 1 != arr[0].length)
				pq.add(new Pair(arr[rp.rowno][rp.colno + 1], rp.rowno, rp.colno + 1));
			else {
				pq.add(new Pair(Integer.MAX_VALUE, rp.rowno, rp.colno));
			}
		}
		
		System.out.println(rp.value);
		

	}

	static class Pair implements Comparable<Pair>{
		int value;
		int rowno;
		int colno;

		public Pair(int value, int rowno, int colno) {
			this.value = value;
			this.rowno = rowno;
			this.colno = colno;
		}

		@Override
		public int compareTo(Pair o) {
			return this.value-o.value;
		}
	}

}
/*
Test cases:
	4 4
	10 20 30 40
	15 25 35 45
	24 29 37 48
	32 33 38 40
	3
	-------------------
	20
	
	4 4
	10 20 30 40
	15 25 35 45
	24 29 37 48
	32 33 38 40
	8
	-----------------
	20

	4 4
	10 20 30 40
	15 25 35 45
	24 29 37 48
	32 44 48 50
	12
	-------------------
	32
	
	Source: https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
	*/