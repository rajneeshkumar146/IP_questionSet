package mystack;
import java.util.*;
public class first_neg_windk {
public static void printfneg(int arr[],int k){
	Queue<Integer> q=new LinkedList<>();
	for(int i=0;i<k;i++){
		if(arr[i]<0)
			q.add(i);
	}
	for(int i=k;i<arr.length;i++){
		if(q.size()==0)
			System.out.print("0 ");
		else
			System.out.print(arr[q.peek()]+" ");
		while(q.size()>0 && q.peek()<i-k+1){
			q.poll();
		}
		if(arr[i]<0)
			q.add(i);
	}
	if(q.size()>0)
		System.out.print(arr[q.poll()]+" ");
	else
		System.out.print(0+" ");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={3,-2,4,5,-3,-5,4,3,4,6};
int k=3;
printfneg(arr, k);
	}

}
