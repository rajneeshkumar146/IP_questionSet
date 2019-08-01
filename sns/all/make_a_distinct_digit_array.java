package pep_sns;

import java.util.Arrays;
import java.util.HashSet;

public class make_a_distinct_digit_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
	     int[] arr = {131, 2, 11, 455};
	     HashSet<Integer> set = new HashSet<>();
	     for(int i=0; i<n; i++){
	         int temp = arr[i];
	         while(temp != 0){
	            int val = temp%10;
	            temp = temp/10;
	            if(!set.contains(val)){
	                set.add(val);
	            }
	         }
	     }
	     int[] result = new int[set.size()];
	     int i= 0;
	     for(int val: set){
	         result[i] = val;
	         i++;
	     }
	     Arrays.sort(result);
	     for(int val : result){
	         System.out.print(val + " ");
	     }
	     System.out.println();

	}

}
