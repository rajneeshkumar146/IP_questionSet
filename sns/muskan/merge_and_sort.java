package pep_sns;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class merge_and_sort {
	/*
	 * 1 -> test cases
3
3
1 2 8
2
4 9
3
1 2 8
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		 for(int t=0; t<test; t++){
		     int N = scn.nextInt();
		     Set<Integer> treeset = new TreeSet<Integer>();
		     for(int i=0; i<N; i++){
		         int n = scn.nextInt(); 
		         for(int j=0; j<n; j++){
		             treeset.add(scn.nextInt());
		         }
		     }
		     for(int val : treeset){
		         System.out.print(val + " ");
		     }
		     System.out.println();
		 }
	     scn.close();
	}

}
