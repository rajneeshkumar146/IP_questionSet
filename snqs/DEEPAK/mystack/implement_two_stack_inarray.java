package mystack;

public class implement_two_stack_inarray {
	static class TwoStack
	{
		int size;
		int top1,top2;
		int arr[] = new int[100];
		TwoStack()
		{
			size = 100;
			top1 = -1;
			top2 = size;
		}
	
	 void push1(int x, TwoStack sq)
	    {
	        if(sq.top1<sq.top2){
	            sq.arr[++sq.top1]=x;
	        }
	    }
	    void push2(int x, TwoStack sq)
	    {
	        if(sq.top2>sq.top1){
	            sq.arr[--sq.top2]=x;
	        }
	    }
	    int pop1(TwoStack sq)
	    {
	        if(sq.top1!=-1){
	            return sq.arr[sq.top1--];
	        }
	        return -1;
	    }
	    int pop2(TwoStack sq)
	    {
	        if(sq.top2!=sq.size)
	        return sq.arr[sq.top2++];
	        return -1;
	    }
	public static void main(String[] args) {
		TwoStack t=new TwoStack();
		t.push1(1, t);
		t.push1(2, t);
		t.push1(3,t);
		t.push1(4, t);
		t.push2(50, t);
		t.push2(40, t);
		t.push2(30, t);
		System.out.println(t.pop1(t));
		System.out.println(t.pop2(t));
		System.out.println(t.pop1(t));
	}
	}
}
