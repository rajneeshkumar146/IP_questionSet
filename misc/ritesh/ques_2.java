package pepques;

import java.util.ArrayList;
import java.util.Scanner;

public class ques_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t>0)
		{
			int sign=1;
			String st=s.next();
			long n=Integer.parseInt(st);
			int count=0;
			long temp=n;
		    ArrayList<Integer> setbitposi=new  ArrayList<>();
			   while(temp > 0)
		        {
		            long a = temp % 2;
		            if(a == 1)
		            {
		               setbitposi.add(count);
		            }
		           count++;
		            temp = temp / 2;
		        }
			
			
			while(n>1)
			{
				sign=sign^1<<0;
			
				if((n&(n-1))==0)
				{
					n=n/2;
				}
				else
				{
					n=n&~(1<<setbitposi.get(setbitposi.size()-1));
					setbitposi.remove(setbitposi.size()-1);
				}
				
			}
			if(sign==0)
			{
				System.out.println("Karan");
			}
			else{
				System.out.println("Arjun");
			}
			t--;
			
		}
	}

}
