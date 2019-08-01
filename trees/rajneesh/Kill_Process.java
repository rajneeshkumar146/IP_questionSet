package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kill_Process {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> result = new ArrayList();
	HashMap<Integer, List<Integer>> map = new HashMap<>();

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		for (Integer i : pid)
			if (!map.containsKey(i))
				map.put(i, new ArrayList<Integer>());
			else
				return result;

		for (int i = 0; i < ppid.size(); i++) {
			if (map.containsKey(ppid.get(i))) {
				map.get(ppid.get(i)).add(pid.get(i));
			}
		}
		System.out.print(map);

		result.add(kill);
		dfs(kill);
		return result;

	}

	private void dfs(int kill) {
		if (map.get(kill).isEmpty())
			return;
		for (Integer i : map.get(kill)) {
			dfs(i);
			result.add(i);
		}

	}
}
