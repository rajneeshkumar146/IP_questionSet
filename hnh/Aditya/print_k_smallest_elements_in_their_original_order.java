package may30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class print_k_smallest_elements_in_their_original_order {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = scn.nextInt();
			int k = scn.nextInt();

			int[] arr = new int[n];
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				pq.add(arr[i]);
			}
			
			
			HashMap<Integer,Integer> set=new HashMap<>();
			for(int i=0;i<k;i++){
				int val=pq.poll();
				set.put(val,set.getOrDefault(val, 0)+1);
			}
			
			for(int val:arr){
				Integer freq=set.get(val);
				
				if(freq!=null && freq>0){
					System.out.print(val+" ");
					set.put(val, freq-1);
				}
			}
			System.out.println();
		}

	}

}
