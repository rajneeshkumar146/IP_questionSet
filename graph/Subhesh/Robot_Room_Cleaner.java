package Graph;

import java.util.HashSet;
import java.util.Objects;

public class Robot_Room_Cleaner {

	public static void main(String[] args) {
	}

	public void cleanRoom(Robot robot) {
		this.robot = robot;
	}

	Robot robot;
	int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

	private  void Backtrack(int row, int col, int d, Robot robot) {
		for (int i = 0; i < 4; i++) {
			int newd = (d + i) % 4;
			int newrow = row + dir[newd][0];
			int newcol = col + dir[newd][1];

			if (!visited.contains(new Pair(newrow, newcol)) && robot.move()) {
				Backtrack(newrow, newcol, newd, robot);
				goBack();
			}
			robot.turnRight();
		}
	}

	class Pair<F, S> {
		F row;
		S col;

		public Pair(F row, S col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object o) {
			Pair<F, S> p = (Pair<F, S>) o;
			return Objects.equals(p.row, this.row) && Objects.equals(p.col, this.col);
		}

		@Override
		public int hashCode() {
			return row.hashCode() ^ col.hashCode();
		}
	}
}
