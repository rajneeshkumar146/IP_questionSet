package pep_misc;

import java.util.HashSet;

public class matrix_row_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
	     String[] sarr = {"0010", "0100", "0010", "0000"};
	     int[] arr = new int[n];
	     for(int i=0; i<n; i++){
	         arr[i] = Integer.parseInt(sarr[i], 2);
	     }
	     HashSet<Integer> set = new HashSet<>();
	     for(int i=0; i<n; i++){
	         if(arr[i] != 0){
	             set.add(arr[i]);
	         }
	     }
	     if(set.size() == 0){
	         System.out.println("-1");
	         return;
	     }else{
	         for(int i=0; i<set.size(); i++){
	             System.out.print(i + " ");
	         }
	         System.out.println();
	     }

	}

}
