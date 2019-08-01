package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackAndWhite {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {
			String[] st = br.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int m = Integer.parseInt(st[1]);
			knight(n, m, 0);
		}
	}
	//res=res-4*(2*m*n-3*n-3*m+4)
	private static void knight(int n, int m, int pos) {
		int[][] dir = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };
		long total = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				long count = 0;
				for (int k = 0; k < dir.length; k++) {
					int rdash = i + dir[k][0];
					int cdash = j + dir[k][1];
					if (rdash >= 0 && rdash < m && cdash >= 0 && cdash < n) {
						count++;
					}
				}
				total = total + ((n * m) - count - 1);
			}
		}
		System.out.println(total);
	}
}
