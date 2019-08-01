package pepques;

import java.util.Scanner;

public class ques_99_setkthbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int k=s.nextInt();
			n=n|1<<(k);
			System.out.println(n);
			
			t--;
		}
	}

}
