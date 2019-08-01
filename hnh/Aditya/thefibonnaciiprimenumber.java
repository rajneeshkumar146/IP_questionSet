package hnh;

import java.util.Scanner;

public class thefibonnaciiprimenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int  test=scn.nextInt();
		for(int t=1;t<=test;t++){
			int n=scn.nextInt();
			String s=n+"";
			System.out.println(fibonnacciprime(s));}

	}
public static int fibonnacciprime(String n){
	 String[] arr = {"2", "3", "5", "13", "89", "233", "1597", "28657", "514229", "433494437", "2971215073", "99194853094755497", "1066340417491710595814572169", "19134702400093278081449423917", "475420437734698220747368027166749382927701417016557193662268716376935476241"};
   
	 for (int i = 0; i < arr.length; i++) {
         if (n.equals(arr[i])) {
             return 1;
         }
     }
     return 0;
}
}
