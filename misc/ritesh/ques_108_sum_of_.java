package pepques;

import java.util.Scanner;

public class ques_108_sum_of_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
			while(t>0){
			
		  
			long n=s.nextLong();
	   
			if(((n&(n-1))!=0)&&n!=0)
				System.out.println("1");
			else
				System.out.println("0");
			t--;
		}
	
	}

}
