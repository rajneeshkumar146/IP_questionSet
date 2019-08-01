package pepques;

import java.util.Scanner;

public class ques_91_changeKthbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int k=s.nextInt();
			 String c=Integer.toBinaryString(n);
		        String[] d=c.split("");
		        if(d[k-1].equals("1"))
		        d[k-1]="0";
		        String e=String.join("",d);
		        int ans=Integer.parseInt(e,2);		
		        System.out.println(ans);
			t--;
		}
	}

}
