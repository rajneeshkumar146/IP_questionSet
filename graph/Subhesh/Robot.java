package Graph;

public interface Robot {
	int row = 1;
	int col = 3;
	int[][] grid = { { 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 1 } };
	int dir = 0;
	int[][] direc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	int temp=0;
	default boolean move() {
		int rdash = row + direc[dir][0];
		int cdash = col + direc[dir][1];
		if (grid[rdash][cdash] == 1) {
			return true;
		} else {
			return false;
		}
	}
}
