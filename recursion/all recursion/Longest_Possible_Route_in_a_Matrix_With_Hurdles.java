package BackTracking;

public class Longest_Possible_Route_in_a_Matrix_With_Hurdles {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		ans = 0;
		LongestPath(arr, visited, 0, 0, 1, 7, 0);
		System.out.println(ans);
	}

	static int ans;

	private static void LongestPath(int[][] arr, boolean[][] visited, int sr, int sc, int dr, int dc, int ans1) {
		if (sr == dr && sc == dc) {
			ans = Math.max(ans, ans1);
			return;
		}
		if (sr + 1 < arr.length && (arr[sr + 1][sc] == 1) && (visited[sr + 1][sc] == false)) {
			visited[sr + 1][sc] = true;
			LongestPath(arr, visited, sr + 1, sc, dr, dc, ans1 + 1);
			visited[sr + 1][sc] = false;
		}
		if (sc + 1 < arr[0].length && (arr[sr][sc + 1] == 1) && (visited[sr][sc + 1] == false)) {
			visited[sr][sc + 1] = true;
			LongestPath(arr, visited, sr, sc + 1, dr, dc, ans1 + 1);
			visited[sr][sc + 1] = false;
		}
		if (sr - 1 >= 0 && (arr[sr - 1][sc] == 1) && (visited[sr - 1][sc] == false)) {
			visited[sr - 1][sc] = true;
			LongestPath(arr, visited, sr - 1, sc, dr, dc, ans1 + 1);
			visited[sr - 1][sc] = false;
		}
		if (sc - 1 >= 0 && (arr[sr][sc - 1] == 1) && (visited[sr][sc - 1] == false)) {
			visited[sr][sc - 1] = true;
			LongestPath(arr, visited, sr, sc - 1, dr, dc, ans1 + 1);
			visited[sr][sc - 1] = false;
		}
	}
}
