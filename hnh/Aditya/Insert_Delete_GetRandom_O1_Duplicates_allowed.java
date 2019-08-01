package june2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Insert_Delete_GetRandom_O1_Duplicates_allowed {

	HashMap<Integer, LinkedList<Integer>> map;
	ArrayList<Integer> arr;

	/** Initialize your data structure here. */
	public Insert_Delete_GetRandom_O1_Duplicates_allowed() {
		map = new HashMap<>();
		arr = new ArrayList<>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val) == false) {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(arr.size());
			map.put(val, list);
			arr.add(val);
			return true;
		} else {
			map.get(val).add(arr.size());
			arr.add(val);
			return false;
		}

	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val) == false) {
			return false;
		}

		LinkedList<Integer> vallist = map.get(val);
		int swapindex = vallist.getFirst();
		vallist.removeFirst();
		map.put(val, vallist);

		if (swapindex < arr.size() - 1) {

			int lastoflist = arr.get(arr.size() - 1);
			LinkedList<Integer> listoflast = map.get(lastoflist);

			arr.set(swapindex, lastoflist);
			listoflast.removeLast();
			listoflast.addFirst(swapindex);

			map.put(lastoflist, listoflast);
		}

		arr.remove(arr.size() - 1);

		if (vallist.size() == 0) {
			map.remove(val);
		}

		return true;

	}

	/** Get a random element from the collection. */
	public int getRandom() {
		Random rand = new Random();
		return arr.get(rand.nextInt(arr.size()));
	}

}
