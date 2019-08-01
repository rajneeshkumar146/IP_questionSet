package mystack;
import java.util.*;
public class min_cost_ropes {
public static long mincostropes(long[] arr){
	long sum=0;
	PriorityQueue<Long> pq=new PriorityQueue<>();
	for(int i=0;i<arr.length;i++){
		pq.add(arr[i]);
	}
	while(!pq.isEmpty()){
		if(pq.size()==1)
			return sum;
		long f=pq.peek();
		pq.remove();
		long s=pq.peek();
		pq.remove();
		long v=f+s;
		sum+=v;
		pq.add(v);
	}
	return sum;
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
long arr[]={6,4,2,3};
System.out.println(mincostropes(arr));
	}

}
