package misc;

import java.util.Scanner;

public class squares_in_matrix {

	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=0;t<test;t++){
			long m=scn.nextInt();
			long n=scn.nextInt();
		    if(n<m){
		    	long temp=m;
		        m=n;
		        n=temp;
		    }
		    long res=0;
		    
		    res=(m)*(m+1)*(2*m+1)/6+(n-m)*(m)*(m+1)/2;
		         
		    System.out.println(res);
		    
		}
	}
}
