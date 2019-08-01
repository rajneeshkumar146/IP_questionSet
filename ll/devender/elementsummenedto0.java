package ll;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class elementsummenedto0 {

	public static void main(String[] args) {

	}

	private static Node head;

	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	private void removeNonZeroElements(Node root) {
		Node n = root;
		Stack<Node> st = new Stack<>();
		ArrayList<Node> list = new ArrayList<>();
		boolean f=false;
		while (n != null) {

			if (n.data > 0) {
				st.push(n);
			} else {
				int sum = n.data;
				while (st.size() > 0) {
					Node temp = st.pop();
					sum += temp.data;
					if (sum == 0) {
						f=true;
                       list.clear();
                       break;
					}
					list.add(temp);
				}
				if(!false){
					list.forEach(i->st.add(i));
					st.add(n);
				}
			}
			
			n = n.next;

		}
		 st.forEach(i -> System.out.print(i.data +" -> "));
		 System.out.println("NULL");

	}
}
