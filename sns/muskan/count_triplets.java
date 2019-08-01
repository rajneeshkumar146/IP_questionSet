package pep_sns;

import java.util.HashSet;

public class count_triplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,3,2};
		int n = 4;
		HashSet<Integer> set = new HashSet<>();
	     for(int i=0; i<n; i++){
	         set.add(arr[i]);
	     }
	     int count = -1;
	     for(int i=0; i<n-1; i++){
	         for(int j=i + 1; j<n; j++){
	             int sum = arr[i] + arr[j];
	             if(set.contains(sum) && i != j){
	                 if(count == -1)
	                    count = 0;
	                 count++;
	             }
	         }
	     }
	     System.out.println(count);
	}

}
