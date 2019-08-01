package ll;

public class designlinedlist {

	  public MyLinkedList() {
		    
	    }
	    Node head;
	    Node tail;
	    int size;
	    private class Node {
	        int data;
	        Node next;
	        
	    }
	    private void handlefirstadd(int data) {
			Node node = new Node();
			node.data = data;
			head = tail = node;
			size = 1;
		}
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int idx) {
	      
	      if (idx < 0 || idx >= size) {
				
				return -1;
			}
			Node node = this.head;
			for (int i = 0; i < idx; i++) {
				node = node.next;
			}
			return node.data;
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	        if(head==null){
	           tail= head=new Node();
	           tail.data= head.data=val;
	            size=1;
	        }else{
	            size++;
	        Node n=new Node();
	            n.data=val;
	        n.next=head;
	        head=n;}
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int data) {
	       if (size == 0) {
				handlefirstadd(data);
			} else {
				Node node = new Node();
				node.data = data;
				tail.next = node;
				tail = node;
				this.size++;
			}
	        
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int ind, int data) {
	       	if (ind < 0 || ind > size) {
				
				return;
			}
			if (ind == 0) {
				addAtHead(data);
			} else if (ind == size) {
				addAtTail(data);
			} else {
				Node our = new Node();
				our.data = data;
				Node node = getnodeati(ind - 1);

				our.next = node.next;
				node.next = our;
				size++;
			}

	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int ind) {
	       if (ind < 0 || ind >= size || size == 0) {
				
				return ;
			} else if (size - 1 == ind) {
			 removelast();
			} else if (ind == 0) {
			 removefirst();
			} else {
				Node nmin1 = getnodeati(ind - 1);
			
				nmin1.next = nmin1.next.next;
				size--;
				
			}

	    }
	    public void removefirst() {
			if (size == 0) {
			
				return ;
			} else if (size == 1) {
				
				tail = null;
				head = null;
				size--;

				
			} else {
				
				head = head.next;
				size--;
				
			}
		}

	    public void removelast() {
			if (size == 0) {
				return;
				
			} else if (size == 1) {
				
				tail = null;
				head = null;
				size--;
				
			} else {
				Node ntbrprevious = getnodeati(size - 2);
			
				ntbrprevious.next = null;
				size--;
				tail = ntbrprevious;
			
			}
		}
	private Node getnodeati(int idx) {
			if (idx < 0 || idx >= size) {
				return null;
			}
			Node node = this.head;
			for (int i = 0; i < idx; i++) {
				node = node.next;
			}
			return node;
		}
}
