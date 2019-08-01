package pep_sns;

import java.util.Arrays;

public class largest_even_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "9979";
   	 int[] arr = new int[num.length()];
   	 for(int i=0; i<num.length(); i++){
   	     arr[i] = (int)(num.charAt(i) - '0');
   	 }
   	 int smallest = -1;
   	 int smallestindx = -1;
   	 //find smallest even
   	 for(int i=0; i<arr.length; i++){
   	     if(arr[i]%2 == 0){
   	         if(smallest == -1){
   	             smallest = arr[i];
   	             smallestindx = i;
   	         }else{
   	             if(smallest > arr[i]){
   	                 smallest = arr[i];
   	                 smallestindx = i;
   	             }
   	         }
   	     }
   	 }
   	 // if no even in arr
   	 if(smallest == -1){
   	     // find odd smallest
   		 for(int i=0; i<arr.length; i++) {
	   	     if(arr[i]%2 != 0){
	   	         if(smallest == -1){
	   	             smallest = arr[i];
	   	             smallestindx = i;
	   	         }else{
	   	             if(smallest > arr[i]){
	   	                 smallest = arr[i];
	   	                 smallestindx = i;
	   	             }
	   	         }
	   	     }
   		 }
   	 }
   	 //swap first and last to exclude the smallest one
   	 int temp = arr[arr.length - 1];
   	 arr[arr.length - 1] = smallest;
   	 arr[smallestindx] = temp; 
   	 //sort rest array
   	 Arrays.sort(arr, 0, arr.length-1);
   	 String result = "";
   	 for(int i = arr.length - 2; i>=0; i--){
   	     result += arr[i];
   	 }
   	 result += smallest;
   	 System.out.println(result);

	}

}
