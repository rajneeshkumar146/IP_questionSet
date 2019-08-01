package pepques;

import java.util.Scanner;

public class ques_27_countallsetbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
int t=s.nextInt();
		while(t>0)
		{
			
			int no=s.nextInt();
		System.out.println(allsetbit(no));
			t--;
		}
	}
	public static long allsetbit(int no)
	{
		long count=0;
		for(int i=1;i<=no;i++){
			int j=0;
			int n=i;
		while(n!=0)
		{
			if((n&1<<j)!=0){
			count++;
			}
			n=n&~(1<<j);
			j++;
		}
		
		}
		return count;
	}

}
