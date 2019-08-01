package mystack;

public class circular_queue {
	class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    int size;
    int count;
    public circular_queue(int k) {
        size=k;
        head=null;
        tail=null;
        count=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        if(head==null){
            head=new ListNode(value);
            tail=head;
            count++;
        }
        else{
            tail.next=new ListNode(value);
            tail=tail.next;
            count++;
        }
        if(isFull()){
            tail.next=head;
        }
        return true;
    }
    
    public boolean deQueue() {
         if (isEmpty()) 
             return false;
        head = head.next;
        count--;
        return true;
    }
    
    public int Front() {
          if (isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
          if (isEmpty()) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        if(count==0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(count==size)
            return true;
        return false;
    }
	public static void main(String[] args) {

	}

}
