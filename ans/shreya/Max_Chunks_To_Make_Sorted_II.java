package InternQuestAS1;

import java.util.Scanner;

public class Max_Chunks_To_Make_Sorted_II {
	public static int maxChunksToSorted(int[] arr) {
		  int[] min = new int[arr.length];
	        int[] max = new int[arr.length];
	        
	        min[arr.length - 1] = arr[arr.length - 1];
	        for (int i = arr.length - 2; i >= 0; i--) {
	            min[i] = Math.min(arr[i], min[i + 1]);
	        }
	        max[0] = arr[0];
	        for (int i = 1; i < arr.length; i++) {
	            max[i] = Math.max(arr[i], max[i-1]);
	        }
	        
	        int count = 1;
	        for (int i = 1; i < arr.length; i++) {
	            if (min[i] >= max[i - 1]) {
	                count++;
	            }
	        }
	        return count;
	        
	        //min from right side should be greater than max of left side then only if we put a cut it will not affect the right side 
	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] a = { 2,1,3,4,4};
		System.out.println(maxChunksToSorted(a));

	}

}
