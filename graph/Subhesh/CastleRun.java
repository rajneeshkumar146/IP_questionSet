package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class CastleRun {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			boolean ans=castle(arr);
			if(ans==true) {
				System.out.println("True");
			}else {
				System.out.println("False");
			}
		}
	}

	private static boolean castle(int[][] arr) {
		if (arr.length == 1) {
			return true;
		}
		if (notconnected(arr) == false) {
			return false;
		}
		if (isconnected(arr) == false) {
			return false;
		}

		int odd = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					count++;
				}
			}
			if (count % 2 != 0) {
				odd++;
			}
		}
		if (odd != 0) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean isconnected(int[][] arr) {
		HashSet<Integer> visited = new HashSet<>();

		dfs(arr, visited, 0);
		if (visited.size() == arr.length) {
			return true;
		} else {
			return false;
		}
	}

	private static void dfs(int[][] arr, HashSet<Integer> visited, int src) {

		visited.add(src);

		for (int i = 0; i < arr.length; i++) {
			if ((arr[src][i] == 1) && (visited.contains(i) == false)) {
				dfs(arr, visited, i);
			}
		}
	}

	private static boolean notconnected(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				return false;
			}
		}
		return true;
	}
}
