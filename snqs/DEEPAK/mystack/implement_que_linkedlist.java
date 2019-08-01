package mystack;

import java.util.*;

public class implement_que_linkedlist {
	static class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}

		QueueNode front, rear;

		void push(int a) {
			QueueNode n = new QueueNode(a);
			if (front == null) {
				front = n;
				rear = n;
			} else {
				rear.next = n;
				rear = rear.next;
			}
		}

		int pop() {
			int data = -1;
			if (front != null) {
				data = front.data;
				front = front.next;
				if (front == null)
					rear = null;
			}
			return data;
		}
	}

	public static void main(String[] args) {
		QueueNode q = new QueueNode(0);
		q.push(7);
		q.push(2);
		q.push(9);
		System.out.println(q.pop());
		System.out.println(q.pop());
	}

}
