package ll;

import java.util.HashMap;

public class clonealinkedlistwithnextrandompointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Node {
		int data;
		Node next;
        Node arb;
		Node(int data) {
			this.data = data;
		}
	}

	public static Node func(Node n) {
		HashMap<Node, Node> list = new HashMap<>();
		for (Node l = n; l != null; l = l.next) {
              list.put(l,new Node(l.data));//just copy
		}
		for(Node l=n;l!=null;l=l.next){
		Node cloned=	list.get(l);
		cloned.next=l.next;//set next of copy from original
		cloned.arb=l.arb;//set arbitary of copy from original
		}
		return list.get(n);//head of cloned list
	}
}
