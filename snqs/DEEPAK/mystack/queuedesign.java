package mystack;
import java.util.*;
public class queuedesign {
public static Queue<Integer> push(int arr[],int n)
	{
	    Queue<Integer> s=new LinkedList<>();
	    for(int i = 0;i<n;i++)
	    s.add(arr[i]);
	    return s;
	}
	public static void pop(Queue<Integer> s)
	{
	 while(s.size()!=0)
	    {
	        System.out.println(s.peek());
	        s.remove();
	    }
	}
	    public static void main(String[] args){
	    int arr[]={1,2,3};
	    int n=arr.length;
	    Queue<Integer> q=push(arr,n);
	    pop(q);
	    }
	    }