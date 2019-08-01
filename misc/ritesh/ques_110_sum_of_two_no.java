package pepques;

import java.util.Scanner;

public class ques_110_sum_of_two_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			int sum=0;
			int carry=0;
			do{
			sum=a^b;
			carry=(a&b)<<1;
			a=sum;
			b=carry;
			}while(carry!=0);
			
		System.out.println(sum);
			t--;
		}
	}

}
