package may30;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericHashMap<K, V> {

	private class HMnode {
		K key;
		V val;

		private HMnode(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}

	private GenericLList<HMnode>[] Buckets = new GenericLList[4]; // total no of
																	// buckets=N
	private int size = 0; // total no of elements ,n

	private double lambda = 0;

	public GenericHashMap() {
		for (int i = 0; i < Buckets.length; i++) {
			Buckets[i] = new GenericLList<>();
		}

	}

	public void put(K key, V val) {
		int bi = Hashfn(key);

		HMnode keynode = findkey(bi, key);

		if (keynode == null) {
			HMnode node2 = new HMnode(key, val);
			Buckets[bi].addlast(node2);
			this.size++;

		} else {
			keynode.val = val;
		}

		lambda = (1.0 * size) / Buckets.length;
		if (lambda > 2.0) {
			rehash();
		}
	}

	private int Hashfn(K key) {
		int hc = key.hashCode();
		int bi = Math.abs(hc) % Buckets.length;
		return bi;
	}

	private HMnode findkey(int bi, K key) {
		GenericLList<HMnode> bucket = Buckets[bi];

		for (int i = 0; i < bucket.size; i++) {

			HMnode node = bucket.removeFirst();
			if (node.key.equals(key)) {
				bucket.addlast(node);
				return node;
			}
			bucket.addlast(node);

		}

		return null;
	}

	private int findkeyidx(int bi, K key) {
		GenericLList<HMnode> bucket = Buckets[bi];

		for (int i = 0; i < bucket.size; i++) {

			HMnode node = bucket.removeFirst();
			if (node.key.equals(key)) {
				bucket.addlast(node);
				return i;
			}
			bucket.addlast(node);

		}

		return -1;
	}

	public boolean containsKey(K key) {
		int bi = Hashfn(key);
		HMnode keynode = findkey(bi, key);
		return keynode == null ? false : true;
	}

	public V get(K key) {
		int bi = Hashfn(key);
		HMnode keynode = findkey(bi, key);
		return keynode == null ? null : keynode.val;
	}

	public V remove(K key) {
		int bi = Hashfn(key);
		int keyidx = findkeyidx(bi, key);
		this.size--;
		return keyidx == -1 ? null : Buckets[bi].removeidx(keyidx).val;
	}

	public ArrayList<K> KeySets() {
		ArrayList<K> keyset = new ArrayList<>();
		for (int i = 0; i < Buckets.length; i++) {
			for (int k = 0; k < Buckets[i].size; i++) {
				HMnode node = Buckets[i].removeFirst();
				keyset.add(node.key);
				Buckets[i].addlast(node);
			}
		}

		return keyset;
	}

	public void display() {
		for (int i = 0; i < Buckets.length; i++) {
			System.out.print("B" + i + " => ");
			for (int k = 0; k < Buckets[i].size; k++) {
				HMnode node = Buckets[i].removeFirst();
				System.out.print(node.key + " - " + node.val + " -> ");
				Buckets[i].addlast(node);
			}
			System.out.println();
		}
	}

	private void rehash() {
		GenericLList<HMnode>[] olddata = Buckets;

		Buckets = new GenericLList[olddata.length * 2];
		this.size = 0;// put increases size,if size!=0 then it will get doubled
						// at the time rehashing is finished

		for (int i = 0; i < Buckets.length; i++) {
			Buckets[i] = new GenericLList<>();
		}

		for (int i = 0; i < olddata.length; i++) {
			while (olddata[i].size > 0) {
				HMnode node = olddata[i].removeFirst();
				put(node.key, node.val);
			}

		}

	}
}
