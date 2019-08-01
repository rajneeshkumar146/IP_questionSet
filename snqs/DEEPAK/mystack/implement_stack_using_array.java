package mystack;

public class implement_stack_using_array {
	   static int top;
		static int arr[] = new int[1000];
		implement_stack_using_array()
		{
			top = -1;
		}
		
	    static void push(int a)
		{
		    arr[++top]=a;
		} 
		
		static int pop()
		{
		    if(top==-1)
		    return -1;
		    return arr[top--];
		}
	

	public static void main(String[] args) {
		implement_stack_using_array st=new implement_stack_using_array();
		push(2);
		push(4);
		push(6);
		push(8);
		System.out.println(pop());
	}

}
