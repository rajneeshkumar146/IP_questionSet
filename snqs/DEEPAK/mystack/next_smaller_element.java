package mystack;

import java.util.*;

class next_smaller_element {
	public static void immed_smaller(int[] arr) {

		
        int n=arr.length;
	     StringBuffer result=new StringBuffer();
	     for(int i=0;i<n;i++)
	     {
	         if(i!=0)
	         {
	          if(arr[i]<arr[i-1]){
	         result.append(arr[i]);
	         result.append(" ");}
	         else{
	         result.append(-1); 
	         result.append(" ");
	         }
	     }
	     }
	     result.append(-1);

	     System.out.println(result);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 11, 8, 9,7, 2, 6, 7,2 };
		int arr2[]={468 ,335, 501 ,170 ,725  };
		immed_smaller(arr2);
	}
}
