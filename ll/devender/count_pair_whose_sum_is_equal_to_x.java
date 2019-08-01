package ll;

import java.util.HashSet;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class count_pair_whose_sum_is_equal_to_x {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countpair(Node n1, Node n2, int x) {
		HashSet<Integer> n2list = new HashSet<>();
		
		for (Node l = n2; l != null; l = l.next) {
			n2list.add(l.data);//store in hashmap
		}
		int count = 0;
		for (Node t1 = n1; t1 != null; t1 = t1.next) {
			if (n2list.contains(x - t1.data)) {//check complementary exist
				count++;
			}
		}
		return count;
	}
	
}
