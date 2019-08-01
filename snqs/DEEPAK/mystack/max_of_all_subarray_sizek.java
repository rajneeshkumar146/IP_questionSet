package mystack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class max_of_all_subarray_sizek {
//	static class Node implements Comparable<Node>{
//		int val;
//		int ind;
//		Node(int v,int i){
//			val=v;
//			ind=i;
//		}
//		public int compareTo(Node o) {
//			return this.val-o.val;
//		}
//	}
//public static void printmax(int arr[],int k){
//	PriorityQueue<Node> pqh=new PriorityQueue<>(Collections.reverseOrder());
//
//	for(int i=0;i<k;i++){
//		pqh.add(new Node(arr[i],i));
//	}
//	System.out.print(pqh.peek().val+" ");
//	for(int i=k;i<arr.length;i++){
//		pqh.add(new Node(arr[i],i));
//		while(pqh.peek().ind<=i-k)
//			pqh.remove();
//		
//		System.out.print(pqh.peek().val+" ");
//
//	}
//	System.out.println();
//}
//	
//public static void printmax2(int[] arr,int k){
//	PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
//	HashMap<Integer,Integer> hm=new HashMap<>();
//	for(int i=0;i<k;i++){
//		pq.add(arr[i]);
//		hm.put(arr[i],i);
//	}
//	System.out.print(pq.peek()+" ");
//	for(int i=k;i<arr.length;i++){
//		int val=arr[i];
//		pq.add(val);
//		hm.put(val,i);
//		
//		while(hm.containsKey(pq.peek()) && hm.get(pq.peek())<=i-k){
//			pq.remove();
//		}
//		System.out.print(pq.peek()+" ");
//	}
//}
public static void printmax3(int[] arr,int k){
	StringBuilder sb=new StringBuilder();
	Deque<Integer> dq=new LinkedList<Integer>();
	for(int i=0;i<k;i++){
	while(dq.size()>0 && arr[dq.peekLast()]<=arr[i]){
		dq.removeLast();
	}
	dq.addLast(i);
	}
	sb.append(arr[dq.peekFirst()]).append(" ");
	for(int i=k;i<arr.length;i++){
		while(dq.size()>0 && dq.peekFirst()<=i-k){
			dq.removeFirst();
		}
		while(dq.size()>0 && arr[dq.peekLast()]<=arr[i]){
			dq.removeLast();
		}
		dq.addLast(i);
		sb.append(arr[dq.peekFirst()]).append(" ");
	}
	System.out.println(sb);
}



	public static void main(String[] args)  {
		int ar[]={1 ,2 ,3 ,1 ,4 ,5 ,2 ,3, 6};
		int k=3;
   printmax3(ar,k);
   System.out.println();
   	 }
}
	
