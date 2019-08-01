package mystack;

public class cppstl {
	void push(queue<int> &q,int x)
	{
	    q.push(x);
	}
	int pop(queue<int> &q)
	{
	    if(q.size()==0)
	    return -1;
	    else{
	    int f=q.front();
	        q.pop();

	    return f;
	    }
	}
	int getSize(queue<int> &q)
	{
	    return q.size();
	}
	int getBack(queue<int> &q)
	{
	    if(q.size()==0){
	        return -1;
	    }
	    return q.back();
		//Your code here
	}
	int getFront(queue<int> &q)
	{
	    if(q.size()==0)
	    return -1;
	    else
	    return q.front();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
