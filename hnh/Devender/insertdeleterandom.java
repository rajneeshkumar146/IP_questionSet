package hnh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class insertdeleterandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<Integer> arr;
	HashMap<Integer, Integer> hash;

	public boolean insert(int val) {
		if (hash.containsKey(val)) {
			return false;
		}
		int s = arr.size();
		hash.put(val, s);
return true;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		Integer v = hash.get(val);
		if (v == null) {
			return false;
		}

		int index = hash.get(val);
		int last = arr.get(arr.size() - 1);
		hash.remove(val);
		Collections.swap(this.arr, arr.size() - 1, index);
		arr.remove(arr.size()-1);
		hash.put(last, index);
		return true;

	}

	/** Get a random element from the collection. */
	public int getRandom() {
Random r=new Random();
int index=r.nextInt(arr.size());
return arr.get(index);
	}

}
