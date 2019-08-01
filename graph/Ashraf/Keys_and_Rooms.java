package InternshipQuestionGraph;

import java.util.HashSet;
import java.util.*;

public class Keys_and_Rooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		Set<Integer> visited = new HashSet<>();
		visited.add(0);

		Stack<Integer> st = new Stack<>();
		st.push(0);

		while (!st.isEmpty()) {

			int roomn = st.pop();
			List<Integer> keys = rooms.get(roomn);

			for (int key : keys) {
				if (!visited.contains(key)) {
					visited.add(key);
					st.add(key);
				}
			}
		}
		return visited.size() == rooms.size();
	}
}
