package pep_sns;

import java.util.Arrays;

public class mega_sale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;// laptops he can sell in one day
		int n = 4;// size of arr
		int[] arr = {-6, 0, 35, 4};
		Arrays.sort(arr);
	     long sum = 0;
	     for(int i=0; i<Math.min(m, n); i++){
	         if(arr[i] < 0){
	             sum  = sum + arr[i];
	         }else
	            break;
	     }
	     System.out.println(sum != 0 ? -sum : "0");

	}

}
