package pepques;

import java.util.Scanner;

public class ques_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			long n=s.nextLong();
			int count=0;
			long temp=n;
			while(temp!=0)
			{
			
				if(temp%2==1 && count%2==0){
					
					n=n-(long)Math.pow(2, count);
				
					
				}
				temp=temp/2;
				count++;
			}
			
			
			   
			System.out.println(n);
			t--;
			
			
		}
	}

}
