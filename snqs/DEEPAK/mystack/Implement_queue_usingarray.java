package mystack;

public class Implement_queue_usingarray {
	int front, rear;
	int arr[] = new int[1000];
	Implement_queue_usingarray()
	{
		this.front=-1;
		this.rear=-1;
	}
	void push(int a)
	{
		 rear=(rear+1)%arr.length;
		 if(rear==front)
			 return;
		 arr[rear]=a;
	     
	}
	int pop()
	{
		 if(rear==front)
			    return -1;
			    front=(front+1)%arr.length;
			    return arr[front];
	} 
	public static void main(String[] args) {

	}

}
