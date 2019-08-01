package may30;

public class GenericLList<T> {
	private class node {
		T data;
		node next;
	};

	node head;
	node tail;
	int size;

	// o(1)
	public void addlast(T val) {

		node n = new node();

		if (size == 0) {
			head = tail = n;
			n.data = val;
			size = 1;
			return;

		}
		n.data = val;
		n.next = null;
		tail.next = n;
		tail = n;
		size++;

	}

	// o(n)
	public void display() {
		for (node p = head; p != null; p = p.next) {
			System.out.print(p.data + "->");
		}
	}

	private void revr(node p) {
		if (p == tail) {
			return;

		}

		revr(p.next);
		p.next.next = p;

	}

	// o(n)
	public void rev() {
		revr(head);
		node temp;
		head.next = null;
		temp = head;
		head = tail;
		tail = temp;
	}

	// o(1)
	public T getfirst() {
		if (size == 0) {
			System.out.println("List is Empty");
			return null;
		}
		return head.data;
	}

	// o(1)
	public T getlast() {
		if (size == 0) {
			System.out.println("List is Empty");
			return null;
		}
		return tail.data;
	}

	// o(n)
	public T getindex(int idx) {
		if (size == 0) {
			System.out.println("List is Empty");
			return null;
		}
		if (idx >= size || idx < 0) {
			System.out.println("Index out of bounds");
			return null;
		}

		node p = head;
		for (int i = 0; i < idx; i++)
			p = p.next;
		return p.data;
	}

	// o(n)
	private node getnodeindex(int idx) {
		if (size == 0) {

			return null;
		}
		if (idx >= size || idx < 0) {

			return null;
		}

		node p = head;
		for (int i = 0; i < idx; i++)
			p = p.next;
		return p;
	}

	// o(1)
	public void addfirst(T val) {
		node n = new node();
		if (size == 0) {
			head = tail = n;
			n.data = val;
			size = 1;
			return;
		}

		n.data = val;
		n.next = head;
		head = n;
		size++;
	}

	// o(n)
	public void addat(T val, int idx) {
		if (idx < 0 || idx > size) {
			System.out.println("Index out of bounds");
			return;
		} else if (size == 0)
			addfirst(val);
		else if (idx == size)
			addlast(val);
		else {
			node n = new node();
			n.data = val;
			n.next = getnodeindex(idx);
			node prev = getnodeindex(idx - 1);
			prev.next = n;
			size++;
		}
	}

	// o(1)
	public T removeFirst() {
		if (size == 0) {
			System.out.println("Removal not possible");
			return null;
		}

		T rv = head.data;
		if (size == 1) {
			head = tail = null;
			size--;
			return rv;
		}

		head = head.next;

		size--;
		return rv;
	}

	// o(n)
	public T removeLast() {
		if (size == 0) {
			System.out.println("Removal not possible");
			return null;
		}

		T rv = tail.data;

		if (size == 1) {
			head = tail = null;
			size--;
			return rv;
		}

		node seclast = getnodeindex(size - 2);
		tail = seclast;
		tail.next = null;
		size--;
		return rv;
	}

	// o(n)
	public T removeidx(int idx) {
		if (size == 0) {
			System.out.println("Removal not possible");
			return null;
		}
		if (idx >= size || idx < 0) {
			System.out.println("Index out of bound");
			return null;
		}

		if (size == 1) {
			T rv = head.data;
			head = tail = null;
			size--;
			return rv;
		}

		if (idx == 0)
			return removeFirst();
		else if (idx == size - 1)
			return removeLast();
		else {
			node prev = getnodeindex(idx - 1);
			node toberem = prev.next;

			prev.next = toberem.next;

			toberem.next = null;

			size--;
			return toberem.data;

		}

	}
}
