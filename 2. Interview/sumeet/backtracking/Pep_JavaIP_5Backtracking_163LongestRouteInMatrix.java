	package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_163LongestRouteInMatrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		int sx = 0;
		int sy = 0;
		int dx = arr.length - 1;
		int dy = arr[0].length - 1;
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		solve(arr, sx, sy, dx, dy, "", visited);
		System.out.println(opsf.length());
	}

	static String opsf = "";
	private static void solve(int[][] arr, int sx, int sy, int dx, int dy, String psf, boolean[][] visited) {
		if(sx == dx && sy == dy){
			if(psf.length() > opsf.length()){
				opsf = psf;
			}
			return;
		}
		
		if(IsInvalidSpot(arr, sx, sy, visited) == true){
			return;
		}
		
		visited[sx][sy] = true;
		solve(arr, sx, sy + 1, dx, dy, psf + "R", visited);
		solve(arr, sx, sy - 1, dx, dy, psf + "L", visited);
		solve(arr, sx + 1, sy, dx, dy, psf + "D", visited);
		solve(arr, sx - 1, sy, dx, dy, psf + "U", visited);
		visited[sx][sy] = false;
	}
	
	private static boolean IsInvalidSpot(int[][] arr, int x, int y, boolean[][] visited) {
		if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length){
			return true;
		} else if(arr[x][y] == 0){
			return true;
		} else if(visited[x][y] == true){
			return true;
		} else {
			return false;
		}
	}

}
