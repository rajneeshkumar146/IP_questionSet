package mystack;
import java.util.*;
import java.util.Collections;

public class chinkey_diamond {
public static int max_diam(int arr[],int k){
	PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
	for(int i=0;i<arr.length;i++){
		pq.add(arr[i]);
	}
	int res=0;
	while(pq.size()>0 && k>0){
		int top=pq.peek();
		pq.remove();
		res+=top;
		pq.add(top/2);
		k--;
	}
	return res;
}
	public static void main(String[] args) {
int[] arr={2 ,1 ,7 ,4 ,2};
int k=3;
System.out.println(max_diam(arr, k));
	}

}
