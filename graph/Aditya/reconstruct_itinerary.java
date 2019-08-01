package june3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class reconstruct_itinerary {
	HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
	LinkedList<String> ans = new LinkedList<>();
	int edges = 1;

	public List<String> findItinerary(List<List<String>> tickets) {

		for (List<String> l : tickets) {
			if (!graph.containsKey(l.get(0))) {
				graph.put(l.get(0), new PriorityQueue<>());
			}

			graph.get(l.get(0)).add(l.get(1));
			edges++;
		}

		Stack<String> stack = new Stack<String>();

		stack.push("JFK");
		while (!stack.isEmpty()) {
			String next = stack.peek();
			if (graph.containsKey(next) && graph.get(next).size() > 0)
				stack.push(graph.get(next).poll());
			else
				ans.addFirst(stack.pop());
		}
		return ans;

	}

}
