package may28;

import java.util.HashSet;
import java.util.Scanner;

public class sum_indexes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			int n = scn.nextInt();
			int[] a_min_b = new int[n];

			for (int i = 0; i < n; i++) {
				a_min_b[i] = scn.nextInt();
			}
			
			HashSet<Integer> c=new HashSet<>();
			
			for (int i = 0; i < n; i++) {
				a_min_b[i] -= scn.nextInt();
				
			}
			for (int i = 0; i < n; i++) {
				c.add(scn.nextInt());
			}
			
			int count=0;
			for (int i = 0; i < n; i++) {
				if(c.contains(a_min_b[i])){
					count++;
				}
				
			}
			
			System.out.println(count);
			
		}

	}

}
