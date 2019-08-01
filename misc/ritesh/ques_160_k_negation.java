package pepques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ques_160_k_negation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int[n];
			
			t--;
		}
	}
public static int largest(int[] a,int k)
{
	PriorityQueue<Integer>que=new PriorityQueue<>();
	for(int i=0;i<a.length;i++)
	{
		que.add(a[i]);
	}
	while(k>0)
	{
		int smallest=que.peek();
		que.remove();
		que.add(-1*smallest);
		k--;
	}
	int res=0;
	while(que.size()>0)
	{
		res+=que.peek();
		que.remove();
	}
return res;
}
}
