package may28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sum_of_elements_between_k1_and_k2_smallest {

	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			int n = scn.nextInt();
			ArrayList<Integer> arr=new ArrayList<>();
			 

			for (int i = 0; i < n; i++) {
				int val = scn.nextInt();
				arr.add(val);
				 
			}

			int k1 = scn.nextInt();
			int k2 = scn.nextInt();

			if (k1 > k2) {
				int temp = k2;
				k2 = k1;
				k1 = temp;
			}

			Collections.sort(arr);
			
			int sum=0;
			
			for(int i=k1; i<k2-1;i++){
				sum+=arr.get(i);
			}

			System.out.println(sum);

		}
	}

}
