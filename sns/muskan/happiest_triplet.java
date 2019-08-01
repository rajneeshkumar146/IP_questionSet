package pep_sns;

import java.util.Arrays;
import java.util.Scanner;

public class happiest_triplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int n = 4;
		int[] arr1 = {15, 12, 18, 9};
		int[] arr2 = {10, 17, 13, 8};
		int[] arr3 = {14, 16, 11, 5};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);
		int i = 0;
		int j = 0;
		int k = 0;
		int[] result = new int[3];
		int res = Integer.MAX_VALUE;
		while (i < n && j < n && k < n) {
			int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
			int max = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));
			int diff = max - min;
			if (diff < res) {
				res = diff;
				result[0] = arr1[i];
				result[1] = arr2[j];
				result[2] = arr3[k];
			}
			if (min == arr1[i])
				i++;
			else if (min == arr2[j])
				j++;
			else
				k++;
		}
		Arrays.sort(result);
		for (int idx = result.length - 1; idx >= 0; idx--) {
			System.out.print(result[idx] + " ");
		}
		System.out.println();
		*/
		Scanner scn = new Scanner(System.in);
		 int test = scn.nextInt();
		 for(int t=0; t<test; t++){
		     int n = scn.nextInt();
		     int[] arr1 = new int[n];
		     int[] arr2 = new int[n];
		     int[] arr3 = new int[n];
		     for(int i=0; i<n; i++){
		         arr1[i] = scn.nextInt();
		     }
		     for(int i=0; i<n; i++){
		         arr2[i] = scn.nextInt();
		     }
		     for(int i=0; i<n; i++){
		         arr3[i] = scn.nextInt();
		     }
		     Arrays.sort(arr1);
		     Arrays.sort(arr2);
		     Arrays.sort(arr3);
		     int i = 0;
		     int j = 0;
		     int k = 0;
		     int[] result = new int[3];
		     int res = Integer.MAX_VALUE;
		     while(i < n && j < n && k < n){
		         int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
		         int max = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));
		         int diff = max - min;
		         if(diff < res){
		             res = diff;
		             result[0] = arr1[i];
		             result[1] = arr2[j];
		             result[2] = arr3[k];
		         }
		        if (min == arr1[i]) 
	                i++; 
	            else if (min == arr2[j]) 
	                j++; 
	            else
	                k++;
		     }
		     Arrays.sort(result);
		     for(int idx=result.length - 1; idx>=0; idx--){
		         System.out.print(result[idx] + " ");
		     }
		     System.out.println();
		 }

	}

}
