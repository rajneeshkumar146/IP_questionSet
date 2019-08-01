package Matrix;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_4Matrix_143FindAllCommonEleementsInAllRows {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		findallCommon(arr);

	}

	static class Pair {
		int count;
		int rowno;

		public Pair(int count, int rowno) {
			this.count = count;
			this.rowno = rowno;
		}
	}

	private static void findallCommon(int[][] arr) {
		HashMap<Integer, Pair> map = new HashMap<>();

		for (int i = 0; i < arr[0].length; i++) {
			map.put(arr[0][i], new Pair(1, 0));// value here keeps the column number
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (map.containsKey(arr[i][j])) {
					Pair pair = map.get(arr[i][j]);
					if (pair.rowno != i) {
						map.put(arr[i][j], new Pair(pair.count + 1, i));
					}
				} else {
					// it is not present in first row, but present in one of 2nd,3rd and so on rows
					// no use of it.
					// ignore it.
				}
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());

		for (int key : keys) {
			Pair pair = map.get(key);
			if (pair.count == arr.length) {
				System.out.print(key + " ");
			}
		}
	}

}
/*
 * Test cases: 4 4 1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4 ------------- 1 2 3 4
 * 
 * 5 5 1 2 3 4 5 1 2 5 4 5 1 2 2 4 5 1 2 3 4 5 1 2 3 9 5 ----------------- 1 2 5
 * 
 * 5 6 1 2 3 4 5 6 1 2 3 4 6 6 1 2 4 4 5 6 1 2 3 4 4 6 1 2 3 4 5 6
 * ---------------- 1 2 4 6
 * 
 * Source:
 * https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
 */