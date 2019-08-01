package mystack;

public class implement_stack_using_linekdlist {
	static class StackNode
	{
		int data;
		StackNode next;

	    StackNode(int a)
	    {
	       data = a;
	       next = null;
	    }
	
	StackNode top;
	 void push(int a) 
	   {
	       StackNode temp = new StackNode(a);
	       temp.next = top;
	       top = temp;
	       }
	   
	   int pop() 
	   {
	       if(top==null)
	       return -1;
	       int data=top.data;
	       top=top.next;
	       return data;
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackNode s=new StackNode(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	}
}
