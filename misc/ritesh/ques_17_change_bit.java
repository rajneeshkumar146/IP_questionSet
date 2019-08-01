package pepques;

import java.util.Scanner;

public class ques_17_change_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int count=0;
			int res=0;
			int oldno=n;
			int newno=oldno;
			while(n!=0)
			{
			
				if(n%2==0){
					
					res=res+(int)Math.pow(2, count);
				}
				n=n/2;
				count++;
			}
			newno+=res;
			System.out.println(res+" "+newno);
			t--;
			
			
		}
	}

}
