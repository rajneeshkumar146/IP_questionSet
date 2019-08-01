package pep_sns;

import java.util.Scanner;

public class number_and_the_digit_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		 int test = scn.nextInt();
		 for(int t=0; t<test; t++){
		     long n = scn.nextLong();
		     long diff = scn.nextLong();
		     long low = 1;
		     long high = n;
		     while(low <= high){
		         long mid = (low + high)/2;
		         if(mid - sumofd(mid) < diff){
		             low = mid + 1;
		         }else{
		             high = mid - 1;
		         }
		     }
		     System.out.println(n - high);
		 }

	}
	 public static long sumofd(long mid){
	     long n = mid;
	     long sum = 0;
	     while(n != 0){
	         sum += n%10;
	         n/=10;
	     }
	     return sum;
	 }

}
