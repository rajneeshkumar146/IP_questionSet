package mystack;

public class queue_designer {
	queue<int>_push(int arr[],int n)
	{
	    queue<int> s;
	    for(int i = 0;i<n;i++)
	    s.push(arr[i]);
	    return s;
	}
	void _pop(queue<int>s)
	{
	 while(s.size()!=0)
	    {
	        cout<<s.front()<<" ";
	        s.pop();
	    }
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
