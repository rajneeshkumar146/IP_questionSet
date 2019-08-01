package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Word_Boggle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {
			int m = Integer.parseInt(br.readLine());
			String[] dictionary = br.readLine().split(" ");
			String[] temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int o = Integer.parseInt(temp[1]);
			char boggle[][] = new char[n][o];
			String[] temp1 = br.readLine().split(" ");
			int count = 0;
			for (int i = 0; i < boggle.length; i++) {
				for (int j = 0; j < boggle[0].length; j++) {
					boggle[i][j] = temp1[count].charAt(0);
					count++;
				}
			}
			Boggle(dictionary, boggle);
		}
	}

	static HashMap<String, Integer> hm;

	static void Boggle(String[] dict, char[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		hm = new HashMap<>();
		for (String X : dict) {
			hm.put(X, 1);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				Find(i, j, matrix, visited, "");
			}
		}

	}

	static void Find(int i, int j, char[][] matrix, boolean[][] visited, String str) {
		visited[i][j] = true;
		str = str + matrix[i][j];

		if (hm.containsKey(str)) {
			System.out.print(str + " "); // For displaying all words(repition allowed)
			// To avoid duplicates, we can use a hashset and then print only the unique
			// values
		}
		int[][] dirs = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };

		for (int[] x : dirs) {
			int newx = i + x[0];
			int newy = j + x[1];

			if (newx >= 0 && newx < matrix.length && newy >= 0 && newy < matrix[0].length
					&& visited[newx][newy] == false) {
				Find(newx, newy, matrix, visited, str);
			}
		}

		visited[i][j] = false;
	}

}
