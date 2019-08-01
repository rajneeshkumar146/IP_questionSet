package may30;

import java.util.PriorityQueue;
import java.util.Scanner;

public class adding_array_elements {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		int t=scn.nextInt();
		
		for(int tc=0;tc<t;tc++){
			int n=scn.nextInt();
			int k=scn.nextInt();
			
			PriorityQueue<Integer> pq=new PriorityQueue<>();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
				pq.add(arr[i]);
			}
			
			for(int i=0;i<k;i++){
				Integer a=pq.poll();
				Integer b=pq.poll();
				if(a==null || b==null){
					System.out.println(-1);
					break;
				}
				else{
					pq.add(a+b);
					if(pq.peek()>=k){
						System.out.println(i+1);
						break;
					}
				}
			}
		}
	}

}
